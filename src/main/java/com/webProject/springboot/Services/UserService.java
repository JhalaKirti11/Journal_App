package com.webProject.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    public UserRepo userrepo;

    public void saveUser(UserEntity ue){
        userrepo.save(ue);
    }

    public List<UserEntity> getUsers(){
        return userrepo.findAll();
    }

    public UserEntity findByName(String name) {
        return userrepo.findByName(name);
    }

}
