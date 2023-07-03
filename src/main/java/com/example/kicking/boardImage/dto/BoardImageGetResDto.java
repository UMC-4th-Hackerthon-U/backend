package com.example.kicking.boardImage.dto;

import com.example.kicking.boardImage.BoardImage;
import lombok.Getter;

@Getter
public class BoardImageGetResDto {
    private String imgUrl;

    public BoardImageGetResDto(BoardImage boardImage) {
        this.imgUrl = boardImage.getImageUrl();
    }
}
