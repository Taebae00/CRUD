package com.example.crud.repository;

import com.example.crud.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Integer> {

    public BoardEntity findByBoardNo(int no);
}