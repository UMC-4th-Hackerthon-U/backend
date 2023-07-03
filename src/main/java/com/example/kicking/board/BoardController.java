package com.example.kicking.board;

import com.example.kicking.board.dto.BoardGetReqDto;
import com.example.kicking.board.dto.BoardGetResDto;
import com.example.kicking.story.dto.StoryGetResDto;
import com.example.kicking.utils.BaseResponse;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/board")
    public BaseResponse<String> insertBoard(@RequestPart(value = "image") List<MultipartFile> multipartFiles,
                                            @RequestPart(value = "boardGetReqDto") BoardGetReqDto boardGetReqDto){
        return new BaseResponse<>(boardService.insertBoard(multipartFiles,boardGetReqDto));
    }

    @GetMapping("/board")
    public BaseResponse<Page<BoardGetResDto>> selectAllBoard(@Param("page") int page){
        return new BaseResponse<>(boardService.selectBoard(page));
    }

}
