package com.example.kicking.story;

import com.example.kicking.utils.BaseResponse;
import com.example.kicking.utils.S3Service;
import com.example.kicking.utils.dto.getS3ResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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
}
