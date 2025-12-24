package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private int commentNo;

    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

    @Column(name = "comment_date")
    private String commentDate;
}
