package com.example.crud.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDTO {

    private int board_no;
    private String title;
    private String content;
    private String writer;
    private String image_url;
    private int board_like;
    private int board_unlike;
    private int hit;
    private String board_date;
}
