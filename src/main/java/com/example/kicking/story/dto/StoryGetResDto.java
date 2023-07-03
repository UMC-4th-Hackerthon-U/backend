package com.example.kicking.story.dto;

import com.example.kicking.member.Member;
import com.example.kicking.story.Story;
import lombok.Getter;

@Getter
public class StoryGetResDto {
    private String img;

    public StoryGetResDto(Story story) {
        this.img = story.getImgUrl();
    }
}
