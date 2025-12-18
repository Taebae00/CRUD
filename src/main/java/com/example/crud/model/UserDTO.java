package com.example.crud.model;

import lombok.Data;

@Data
public class UserDTO {

    private int user_no;
    private String id;
    private String password;
    private String name;
    private String kakao_id;
    private String profile_url;
}
