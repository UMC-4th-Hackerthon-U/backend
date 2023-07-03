package com.example.kicking.battleboard;

import com.example.kicking.battleboard.dto.RandomBattleInfoDto;
import com.example.kicking.battleboard.dto.ViewRandomBattleResDto;
import com.example.kicking.board.Board;
import com.example.kicking.member.MemberRepository;
import com.example.kicking.utils.BaseException;
import com.example.kicking.utils.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class BattleBoardService {

    private final BattleBoardRepository battleBoardRepository;
    private final MemberRepository memberRepository;

    public ViewRandomBattleResDto viewRandomBattle() throws BaseException {
        try{
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startTime = LocalDateTime.of(now.getYear(),
                    now.getMonth(), now.getDayOfMonth(), 0, 0, 0);
            List<BattleBoard> battleBoards = battleBoardRepository.findRandomBattle(startTime);
            Board bestBoard = battleBoards.get(0).getBestBoard();
            Board challengeBoard = battleBoards.get(0).getChallengeBoard();

            String bestContent = bestBoard.getContent();
            String challengeContent = challengeBoard.getContent();
            if (bestContent.length() > 40)
                bestContent = bestContent.substring(0, 40);
            if (challengeContent.length() > 40)
                challengeContent = challengeContent.substring(0, 40);

            String bestNickName = memberRepository.findNickNameById(bestBoard.getMember().getId());
            String challengeNickName = memberRepository.findNickNameById(bestBoard.getMember().getId());
            if (bestNickName.length() > 10)
                bestNickName = bestNickName.substring(0, 10);
            if (challengeNickName.length() > 10)
                challengeNickName = challengeNickName.substring(0, 10);

            RandomBattleInfoDto bestBoardInfo = RandomBattleInfoDto.builder()
                    .boardContent(bestContent)
                    .boardId(bestBoard.getId())
                    .memberNickName(bestNickName)
                    .memberProfileImage(memberRepository.findProfileImageById(bestBoard.getMember().getId()))
                    .build();
            RandomBattleInfoDto challengeBoardInfo = RandomBattleInfoDto.builder()
                    .boardContent(challengeContent)
                    .boardId(challengeBoard.getId())
                    .memberNickName(challengeNickName)
                    .memberProfileImage(memberRepository.findProfileImageById(bestBoard.getMember().getId()))
                    .build();

            return ViewRandomBattleResDto.builder()
                    .bestBoardInfo(bestBoardInfo)
                    .challengeBoardInfo(challengeBoardInfo)
                    .build();

        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
