package com.example.kicking.battleboard;

import com.example.kicking.battleboard.dto.*;
import com.example.kicking.utils.BaseException;
import com.example.kicking.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
/*
@Tag(name = "캡슐 API")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "요청에 성공하였습니다."),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
})
*/
@RequestMapping("/battle")
public class BattleBoardController {

    private final BattleBoardService battleBoardService;

    /**
     * 진행중인 배틀 하나를 랜덤 조회
     * */
    // @Tag(name = "진행중인 배틀 하나를 랜덤 조회 API")
    // @Operation(summary = "진행중인 배틀 하나를 랜덤 조회", description = "진행중인 배틀 하나를 랜덤 조회하기 위한 API")
    @GetMapping("/resume/random")
    public BaseResponse<ViewRandomBattleResDto> viewRandomBattle(){
        try{
            return new BaseResponse<>(battleBoardService.viewRandomBattle());
        }catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 흑역사 좋아요 상위 3개 조회
     * */
    // @Tag(name = "흑역사 좋아요 상위 3개 조회 API")
    // @Operation(summary = "흑역사 좋아요 상위 3개 조회", description = "흑역사 좋아요 상위 3개 조회하기 위한 API")
    @GetMapping("/likes")
    public BaseResponse<List<ViewMostLikesResDto>> viewMostLikes(){
        try{
            return new BaseResponse<>(battleBoardService.viewMostLikes());
        }catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
