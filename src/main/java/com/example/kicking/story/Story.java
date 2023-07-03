package com.example.kicking.story;

import com.example.kicking.member.Member;
import jakarta.persistence.*;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    private String imgUrl;

    public Story(Member member, String imgUrl) {
        this.member = member;
        this.imgUrl = imgUrl;
    }
}
