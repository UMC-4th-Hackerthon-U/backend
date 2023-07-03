package com.example.kicking.battleboard.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class RandomBattleInfoDto {

    // @Schema(name = "memberProfileImage", example = "1", required = true, description = "캡슐 인덱스")
    private String memberProfileImage;
    // @Schema(name = "creationDateTime", example = "DATETIME", required = true, description = "생성일")
    private String memberNickName;
    // @Schema(name = "capsuleTitle", example = "제목", required = true, description = "캡슐 제목")
    private Long boardId;
    // @Schema(name = "releaseDateTime", example = "DATETIME", required = true, description = "해제일")
    private String boardContent;

    @Builder
    public RandomBattleInfoDto(String memberProfileImage, String memberNickName, Long boardId, String boardContent) {
        this.memberProfileImage = memberProfileImage;
        this.memberNickName = memberNickName;
        this.boardId = boardId;
        this.boardContent = boardContent;
    }

}
