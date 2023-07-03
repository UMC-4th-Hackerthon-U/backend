package com.example.kicking.share;

import com.example.kicking.board.Board;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Board newBoard;

    @ManyToOne
    private Board sharedBoard;

    public Share() {
    }

    @Builder
    public Share(Board sharedBoard, Board newBoard) {
        this.sharedBoard = sharedBoard;
        this.newBoard = newBoard;
    }

}
