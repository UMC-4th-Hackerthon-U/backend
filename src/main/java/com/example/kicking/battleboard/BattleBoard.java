package com.example.kicking.battleboard;

import com.example.kicking.board.Board;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class BattleBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bestBoard")
    private Board bestBoard;

    @ManyToOne
    @JoinColumn(name = "challengeBoard")
    private Board challengeBoard;
}
