package com.example.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class CommentEntity {

    @Id
    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;
}
