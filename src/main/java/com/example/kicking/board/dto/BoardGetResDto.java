package com.example.kicking.board.dto;

import com.example.kicking.board.Board;
import com.example.kicking.boardImage.BoardImage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class BoardGetResDto {
    private String content;
    private Integer accLike;
    private Integer dayLike;
    private Integer commentNumber;
    private Integer scrapNumber;
    private String boardImageUrl;

    public BoardGetResDto(Board board) {
        this.content = board.getContent();
        this.accLike = board.getAccLike();
        this.dayLike = board.getDayLike();
        this.commentNumber = board.getCommentNumber();
        this.scrapNumber = board.getScrapNumber();
        this.boardImageUrl =board.getBoardImages().size() >0 ? board.getBoardImages().get(0).getImageUrl()
          : this.boardImageUrl;
    }
}
