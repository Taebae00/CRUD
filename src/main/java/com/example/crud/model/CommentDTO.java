package com.example.crud.model;

import lombok.Data;

@Data
public class CommentDTO {

    private int board_no;
    private String writer;
    private String content;
}
