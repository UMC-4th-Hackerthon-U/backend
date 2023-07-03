package com.example.kicking.battleboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BattleBoardRepository extends JpaRepository<BattleBoard, Long> {

    @Query(value = "SELECT id, created_at, updated_at, best_board, challenge_board FROM battle_board c JOIN (SELECT id as cid FROM board WHERE created_at >= :startAt) b ON c.challenge_board = b.cid ORDER BY RAND() LIMIT 1", nativeQuery = true)
    List<BattleBoard> findRandomBattle(@Param("startAt") LocalDateTime startAt);
}
