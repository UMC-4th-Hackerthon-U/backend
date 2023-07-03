package com.example.kicking.battleboard;

import com.example.kicking.board.Board;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;

@Entity
public class BattleBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Board bestBoard;

    @ManyToOne
    private Board challengeBoard;
}
