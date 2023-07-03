package com.example.kicking.story;

import com.example.kicking.story.dto.StoryGetResDto;
import com.example.kicking.utils.BaseResponse;
import com.example.kicking.utils.S3Service;
import com.example.kicking.utils.dto.getS3ResultDto;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class StoryController {
  private final StoryService storyService;

  @PostMapping("/story")
  public BaseResponse<String> insertStory(@RequestPart(value = "image") List<MultipartFile> multipartFiles){
      return new BaseResponse<>(storyService.insertStory(multipartFiles));
  }

  @GetMapping("/story")
  public BaseResponse<Page<StoryGetResDto>> getStory(@Param("page") int page){
      return new BaseResponse<>(storyService.findPageStory(page));
  }
}
