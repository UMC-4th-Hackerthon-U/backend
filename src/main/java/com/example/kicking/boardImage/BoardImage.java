package com.example.kicking.boardImage;

import com.example.kicking.board.Board;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class BoardImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    public BoardImage(String imageUrl, Board board) {
        this.imageUrl = imageUrl;
        this.board = board;
    }
}
