package com.example.kicking.battleboard;

import com.example.kicking.board.Board;
import jakarta.persistence.*;

@Entity
public class BattleBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Board bestBoard;

    @ManyToOne
    private Board challengeBoard;
}
