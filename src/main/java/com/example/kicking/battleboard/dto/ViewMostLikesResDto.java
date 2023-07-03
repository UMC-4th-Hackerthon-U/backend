package com.example.kicking.battleboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ViewMostLikesResDto {

    // @Schema(name = "memberProfileImage", example = "1", required = true, description = "캡슐 인덱스")
    private String memberProfileImage;
    // @Schema(name = "creationDateTime", example = "DATETIME", required = true, description = "생성일")
    private String memberNickName;
    // @Schema(name = "capsuleTitle", example = "제목", required = true, description = "캡슐 제목")
    private Long boardId;
    // @Schema(name = "releaseDateTime", example = "DATETIME", required = true, description = "해제일")
    private String boardContent;
    // @Schema(name = "releaseDateTime", example = "DATETIME", required = true, description = "해제일")
    private Integer boardDayLike;

    @Builder
    public ViewMostLikesResDto(String memberProfileImage, String memberNickName, Long boardId, String boardContent, Integer boardDayLike) {
        this.memberProfileImage = memberProfileImage;
        this.memberNickName = memberNickName;
        this.boardId = boardId;
        this.boardContent = boardContent;
        this.boardDayLike = boardDayLike;
    }
}
