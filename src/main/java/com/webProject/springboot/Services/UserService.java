package com.webProject.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Repository.UserRepository;

@Component
public class UserService {
    
    @Autowired
    public UserRepository user_repo;

    public void saveUser(UserEntity ue){
        user_repo.save(ue);
    }

    public List<UserEntity> getUsers(){
        return user_repo.findAll();
    }

    public UserEntity findByName(String name){
        return user_repo.findByName(name);
    }

}