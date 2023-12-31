package com.example.kicking.board;

import com.example.kicking.board.dto.BoardGetDto;
import com.example.kicking.board.dto.BoardGetReqDto;
import com.example.kicking.board.dto.BoardGetResDto;
import com.example.kicking.story.dto.StoryGetResDto;
import com.example.kicking.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    /**
     * 흑역사 추가
     * @param multipartFiles
     * @param boardGetReqDto
     * @return
     */
    @PostMapping("/board")
    public BaseResponse<String> insertBoard(@RequestPart(value = "image") List<MultipartFile> multipartFiles,
                                            @RequestPart(value = "boardGetReqDto") BoardGetReqDto boardGetReqDto){
        return new BaseResponse<>(boardService.insertBoard(multipartFiles,boardGetReqDto));
    }

    /**
     * 모든 흑역사 조회(Paging)
     * @param page
     * @return
     */
    @GetMapping("/board")
    public BaseResponse<Page<BoardGetResDto>> selectAllBoard(@Param("page") int page){
        return new BaseResponse<>(boardService.selectAllBoard(page));
    }

    @PostMapping("/board/battle/{bestIdx}")
    public BaseResponse<String> insertBoardWithBattle(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles,
                                            @RequestPart(value = "boardGetReqDto") BoardGetReqDto boardGetReqDto,
                                            @PathVariable("bestIdx") Long bestIdx){
        return new BaseResponse<>(boardService.insertBoardWithBattle(multipartFiles, boardGetReqDto, bestIdx));
    }

    @PostMapping("/board/share/{sharedIdx}")
    public BaseResponse<String> insertBoardWithShare(@RequestPart(value = "image", required = false) List<MultipartFile> multipartFiles,
                                                      @RequestPart(value = "boardGetReqDto") BoardGetReqDto boardGetReqDto,
                                                      @PathVariable("sharedIdx") Long sharedIdx){
        return new BaseResponse<>(boardService.insertBoardWithShare(multipartFiles, boardGetReqDto, sharedIdx));
    }

    @GetMapping("/board/{id}")
    public BaseResponse<BoardGetDto> selectBoard(@PathVariable Long id){
        return new BaseResponse<>(boardService.selectBoard(id));
    }
}
