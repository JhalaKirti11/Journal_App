package com.webProject.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webProject.springboot.Entity.UserEntity;
import com.webProject.springboot.Services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    public UserService userserve;

    @GetMapping("/getUsers")
    public List<UserEntity> getUsers(){
        return userserve.getUsers();
    }

    @PostMapping
    public boolean saveUser(@RequestBody UserEntity ue){
        userserve.saveUser(ue);
        return true;
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> updateUser(@PathVariable String name, @RequestBody UserEntity user){

        UserEntity userInDb = userserve.findByName(name);

        if(userInDb != null){
            userInDb.setName(user.getName());
            userInDb.setPassword(user.getPassword());
            userserve.saveUser(userInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
