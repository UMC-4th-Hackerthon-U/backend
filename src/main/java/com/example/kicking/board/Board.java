package com.example.kicking.board;

import com.example.kicking.boardImage.BoardImage;
import com.example.kicking.member.Member;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
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

    @OneToMany(mappedBy = "board")
    private List<BoardImage> boardImages = new ArrayList<>();

    public Board(String content, Member member) {
        this.content = content;
        this.member = member;
    }
}
