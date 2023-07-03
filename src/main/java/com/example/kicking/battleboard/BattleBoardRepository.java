package com.example.kicking.battleboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BattleBoardRepository extends JpaRepository<BattleBoard, Long> {

    @Query(value = "SELECT * FROM BattleBoard c LEFT JOIN (SELECT * FROM Board WHERE createdDate >= :startAt) b ON c.challengeBoard = b.id ORDER BY RAND() LIMIT 1)", nativeQuery = true)
    List<BattleBoard> findRandomBattle(@Param("startAt") LocalDateTime startAt);
}
