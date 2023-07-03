package com.example.kicking.story;

import com.example.kicking.member.Member;
import com.example.kicking.utils.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Story extends BaseTimeEntity {
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
