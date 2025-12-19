package com.example.crud.model;

import lombok.Data;

@Data
public class BoardDTO {

    private int board_no;
    private String title;
    private String content;
    private String writer;
    private int board_like;
    private int board_unlike;
    private int hit;
}
