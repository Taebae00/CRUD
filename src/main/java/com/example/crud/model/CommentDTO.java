package com.example.crud.model;

import lombok.Data;

@Data
public class CommentDTO {

    private int comment_no;
    private int board_no;
    private String writer;
    private String content;
    private String comment_date;
}
