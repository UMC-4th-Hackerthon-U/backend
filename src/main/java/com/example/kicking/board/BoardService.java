package com.example.kicking.board;


import com.example.kicking.battleboard.BattleBoard;
import com.example.kicking.battleboard.BattleBoardRepository;
import com.example.kicking.board.dto.BoardGetReqDto;
import com.example.kicking.board.dto.BoardGetResDto;
import com.example.kicking.boardImage.BoardImage;
import com.example.kicking.boardImage.BoardImageRepository;
import com.example.kicking.member.Member;
import com.example.kicking.member.MemberRepository;
import com.example.kicking.share.Share;
import com.example.kicking.share.ShareRepository;
import com.example.kicking.utils.S3Service;
import com.example.kicking.utils.dto.getS3ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final BoardImageRepository boardImageRepository;
    private final S3Service s3Service;
    private final BattleBoardRepository battleBoardRepository;
    private final ShareRepository shareRepository;

    public String insertBoard(List<MultipartFile> multipartFiles, BoardGetReqDto boardGetReqDto){
        Member member = memberRepository.findById(1L).orElseThrow();
        Board board = new Board(boardGetReqDto.getContent(), member);
        boardRepository.save(board);
        List<getS3ResultDto> getS3ResultDtos = s3Service.uploadFile(multipartFiles);
        for (getS3ResultDto getS3ResultDto : getS3ResultDtos) {
            BoardImage boardImage = new BoardImage(getS3ResultDto.getImgUrl(), board);
            boardImageRepository.save(boardImage);
        }
        return "흑역사 추가 완료";
    }

    public Page<BoardGetResDto> selectBoard(int page){
        PageRequest pageRequest = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Board> results = boardRepository.findAll(pageRequest);
        return results.map(BoardGetResDto::new);
    }

    public String insertBoardWithBattle(List<MultipartFile> multipartFiles, BoardGetReqDto boardGetReqDto, Long bestIdx){
        String message = insertBoard(multipartFiles, boardGetReqDto);
        List<Board> boards = boardRepository.findIdByOrderByIdDesc();
        BattleBoard battleBoard = BattleBoard.builder()
                .bestBoard(boardRepository.findById(bestIdx).get())
                .challengeBoard(boardRepository.findById(boards.get(0).getId()).get())
                .build();
        battleBoardRepository.save(battleBoard);
        return message;
    }

    public String insertBoardWithShare(List<MultipartFile> multipartFiles, BoardGetReqDto boardGetReqDto, Long shareIdx){
        String message = insertBoard(multipartFiles, boardGetReqDto);
        List<Board> boards = boardRepository.findIdByOrderByIdDesc();
        Share shareBoard = Share.builder()
                .sharedBoard(boardRepository.findById(shareIdx).get())
                .newBoard(boardRepository.findById(boards.get(0).getId()).get())
                .build();
        shareRepository.save(shareBoard);
        return message;
    }
}
