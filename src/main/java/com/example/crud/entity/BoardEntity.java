package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "writer")
    private String writer;

    @Column(name = "board_like")
    private int boardLike;

    @Column(name = "board_unlike")
    private int boardUnlike;

    @Column(name = "hit")
    private int hit;

    @Column(name = "image_url")
    private String imageUrl;
}
