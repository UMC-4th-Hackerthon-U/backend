package com.example.kicking.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b")
    Page<Board> findAll(PageRequest pageRequest);

    @Query("select b from Board b join fetch b.boardImages")
    List<Board> findAllBoard();
}
