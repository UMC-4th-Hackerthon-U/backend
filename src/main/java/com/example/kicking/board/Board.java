package com.example.kicking.board;

import com.example.kicking.member.Member;
import jakarta.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Integer accLike;
    private Integer dayLike;
    private Integer commentNumber;
    private Integer scrapNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
