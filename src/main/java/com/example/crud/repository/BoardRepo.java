package com.example.crud.repository;

import com.example.crud.entity.BoardEntity;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Integer> {

    BoardEntity findByBoardNo(int no);

    @Transactional
    @Modifying
    @Query("update BoardEntity b set b.hit = b.hit + 1 where b.boardNo = :no")
    void hitUp(@Param("no")int no);

    @Transactional
    @Modifying
    @Query("update BoardEntity b set b.boardLike = b.boardLike + 1 where b.boardNo = :board_no")
    void likeUp(@Param("board_no")int board_no);

    @Transactional
    @Modifying
    @Query("update BoardEntity b set b.boardUnlike = b.boardUnlike + 1 where b.boardNo = :board_no")
    void UnlikeUp(@Param("board_no")int board_no);
}