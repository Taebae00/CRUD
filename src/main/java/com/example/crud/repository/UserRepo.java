package com.example.crud.repository;

import com.example.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query("select u.name from UserEntity u where u.name = :nickname")
    String checkName(String nickname);

    @Query("select u.id from UserEntity u where u.id = :id")
    String checkId(String id);

    @Query("select u.userNo from UserEntity u where u.name = :nickName and u.id = :id")
    int checkJoin(String nickName, String id);

    UserEntity findById(String id);
}
