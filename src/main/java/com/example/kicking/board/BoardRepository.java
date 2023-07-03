package com.example.kicking.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT * FROM Board ORDER BY dayLike DESC LIMIT 3)", nativeQuery = true)
    List<Board> findBoardByLikes();
}
