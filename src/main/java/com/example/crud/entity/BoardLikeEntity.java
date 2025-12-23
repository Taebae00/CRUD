package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "board_like")
public class BoardLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_like_no")
    private int boardLikeNo;

    @Column(name = "board_no")
    private int boardNo;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "type")
    private String type;
}
