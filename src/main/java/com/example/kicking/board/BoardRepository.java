package com.example.kicking.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Query("select b from Board b")
    Page<Board> findAll(PageRequest pageRequest);

    @Query("select b from Board b join fetch b.boardImages where b.id = :boardId")
    Optional<Board> findById(@Param("boardId") Long boardId);

}
