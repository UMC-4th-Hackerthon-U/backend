package com.example.kicking.battleboard.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ViewRandomBattleResDto {

    // @Schema(name = "privateList", required = true, description = "비공개 리스트")
    RandomBattleInfoDto bestBoardInfo;
    // @Schema(name = "privateList", required = true, description = "비공개 리스트")
    RandomBattleInfoDto challengeBoardInfo;

    @Builder
    public ViewRandomBattleResDto(RandomBattleInfoDto bestBoardInfo, RandomBattleInfoDto challengeBoardInfo) {
        this.bestBoardInfo = bestBoardInfo;
        this.challengeBoardInfo = challengeBoardInfo;
    }

}
