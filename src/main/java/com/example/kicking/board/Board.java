package com.example.kicking.board;

import com.example.kicking.member.Member;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private Integer accLike;
    private Integer dayLike;
    private Integer commentNumber;
    private Integer scrapNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;
}
