package com.example.kicking.battleboard;

import com.example.kicking.board.Board;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
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

    @Builder
    public BattleBoard(Board bestBoard, Board challengeBoard) {
        this.bestBoard = bestBoard;
        this.challengeBoard = challengeBoard;
    }

}
