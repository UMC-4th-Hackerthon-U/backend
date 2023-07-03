package com.example.kicking.share;

import com.example.kicking.board.Board;
import jakarta.persistence.*;

@Entity
public class Share {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Board newBoard;

    @ManyToOne
    private Board sharedBoard;
}
