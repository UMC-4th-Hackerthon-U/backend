package com.example.kicking.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findNickNameById(Long id);
    Member findProfileImageById(Long id);
}
