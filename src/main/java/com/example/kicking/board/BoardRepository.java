package com.example.kicking.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "SELECT * FROM board ORDER BY day_like DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByLikes();

    @Query(value = "SELECT * FROM board ORDER BY scrap_number DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByScraps();

    @Query(value = "SELECT * FROM board ORDER BY comment_number DESC LIMIT 3", nativeQuery = true)
    List<Board> findBoardByShares();

    @Query("select b from Board b")
    Page<Board> findAll(PageRequest pageRequest);

    @Query("select b from Board b join fetch b.boardImages")
    List<Board> findAllBoard();

    List<Board> findIdByOrderByIdDesc();
    @Query("select b from Board b join fetch b.boardImages where b.id = :boardId")
    Optional<Board> findById(@Param("boardId") Long boardId);

}
