package com.example.crud.service;

import com.example.crud.entity.UserEntity;
import com.example.crud.model.UserDTO;
import com.example.crud.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public int checkName(String nickname) {

        String dup = userRepo.checkName(nickname);

        if(dup == null){
            return  1;
        }

        return dup.length();
    }

    public int checkId(String id) {

        String dup = userRepo.checkId(id);

        if(dup == null){
            return  1;
        }

        return dup.length();
    }

    public int joinOk(String nickName, String id, String password){

        UserEntity user = new UserEntity();
        user.setName(nickName);
        user.setId(id);
        user.setPassword(password);

        userRepo.save(user);

        return userRepo.checkJoin(nickName, id);
    }

    public UserDTO loginCheck(String id, String password) {

        UserEntity dto = userRepo.findById(id);

        if(dto == null){
            return null;
        }else if(!dto.getPassword().equals(password)){
            return null;
        }else {

            UserDTO userDTO = new UserDTO();
            userDTO.setUser_no(dto.getUserNo());
            userDTO.setName(dto.getName());
            userDTO.setId(dto.getId());
            userDTO.setPassword(dto.getPassword());
            userDTO.setKakao_id(dto.getKakaoId());
            return userDTO;
        }

    }
}
