package com.example.kicking.story;

import com.example.kicking.member.Member;
import com.example.kicking.member.MemberRepository;
import com.example.kicking.story.dto.StoryGetResDto;
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
public class StoryService {
    private final StoryRepository storyRepository;
    private final MemberRepository memberRepository;
    private final S3Service s3Service;
    public String insertStory(List<MultipartFile> multipartFiles){
        Member member = memberRepository.findById(1L).orElseThrow();
        List<getS3ResultDto> getS3ResultDtos = s3Service.uploadFile(multipartFiles);
        Story story = new Story(member, getS3ResultDtos.get(0).getImgUrl());
        storyRepository.save(story);
        return "스토리 추가 완료했습니다";
    }

    public Page<StoryGetResDto> findPageStory(int page){
        PageRequest pageRequest = PageRequest.of(page, 4, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<Story> results = storyRepository.findAll(pageRequest);
        return results.map(StoryGetResDto::new);
    }
}
