package com.example.kicking.board.dto;

import com.example.kicking.board.Board;
import com.example.kicking.boardImage.BoardImage;
import com.example.kicking.boardImage.dto.BoardImageGetResDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BoardGetDto {
    private String memberName;
    private String content;
    private Integer accLike;
    private Integer dayLike;
    private Integer commentNumber;
    private Integer scrapNumber;
    private List<BoardImageGetResDto> boardImageList;

    public BoardGetDto(Board board) {
        this.memberName = board.getMember().getNickName();
        this.content = board.getContent();
        this.accLike = board.getAccLike();
        this.dayLike = board.getDayLike();
        this.commentNumber = board.getCommentNumber();
        this.scrapNumber = board.getScrapNumber();
        this.boardImageList = board.getBoardImages().stream()
                .map(BoardImageGetResDto::new)
                .collect(Collectors.toList());
    }
}
