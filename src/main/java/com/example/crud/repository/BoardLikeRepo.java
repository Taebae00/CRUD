package com.example.crud.repository;

import com.example.crud.entity.BoardLikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardLikeRepo extends JpaRepository<BoardLikeEntity, Integer> {

    boolean existsByUserIdAndBoardNo(String userId, int boardNo);
}
