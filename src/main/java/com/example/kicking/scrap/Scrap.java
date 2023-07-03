package com.example.kicking.scrap;

import com.example.kicking.board.Board;
import com.example.kicking.member.Member;
import jakarta.persistence.*;

@Entity
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;
    @ManyToOne
    private Board board;
}
