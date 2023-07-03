package com.example.kicking.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT * FROM board ORDER BY day_like DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByLikes();

    @Query(value = "SELECT * FROM board ORDER BY scrap_number DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByScraps();

    @Query(value = "SELECT * FROM board ORDER BY comment_number DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByShares();
}
