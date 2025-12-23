package com.example.crud.model;

import lombok.Data;

@Data
public class BoardLikeDTO {

    private int board_like_no;
    private int board_no;
    private String user_id;
    private String type;
}
