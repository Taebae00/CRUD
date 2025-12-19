package com.example.crud.service;

import com.example.crud.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public int checkName(String name) {

        String dup = userRepo.checkName(name);

        return dup.length();
    }
}
