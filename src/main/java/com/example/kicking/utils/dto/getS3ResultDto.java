package com.example.kicking.utils.dto;

import lombok.Getter;

@Getter
public class getS3ResultDto {
    private String imgUrl;

    public getS3ResultDto(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
