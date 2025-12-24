package com.example.crud.repository;

import com.example.crud.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {
    List<CommentEntity> findByBoardNo(int boardNo);
}
