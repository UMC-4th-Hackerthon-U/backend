package com.example.kicking.board;


import com.example.kicking.board.dto.BoardGetDto;
import com.example.kicking.board.dto.BoardGetReqDto;
import com.example.kicking.board.dto.BoardGetResDto;
import com.example.kicking.boardImage.BoardImage;
import com.example.kicking.boardImage.BoardImageRepository;
import com.example.kicking.member.Member;
import com.example.kicking.member.MemberRepository;
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

    public Page<BoardGetResDto> selectAllBoard(int page){
        PageRequest pageRequest = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Board> results = boardRepository.findAll(pageRequest);
        return results.map(BoardGetResDto::new);
    }

    public BoardGetDto selectBoard(Long boardId){
        Board board = boardRepository.findById(boardId).orElseThrow();
        return new BoardGetDto(board);
    }

}
