package com.webProject.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Repository.UserRepo;

public class UserService {
    
    @Autowired
    public UserRepo userrepo;

    public void saveUser(UserEntity ue){
        userrepo.save(ue);
    }

    public List<UserEntity> getUsers(){
        return userrepo.findAll();
    }

}
