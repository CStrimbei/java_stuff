package com.example.lab11.Spring;

import com.example.lab11.Entities.UserEntity;
import com.example.lab11.Spring.Services.UserService;
import com.example.lab11.Spring.models.ClientObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class ProjectWrapper {

    private UserService userService;
    @Autowired public ProjectWrapper(UserService userService){
        this.userService=userService;
    }
    @PostMapping(
            value = "/addUser", consumes = "application/json", produces = "application/json"
    )
    public ResponseEntity<Object> addUser (@RequestBody ClientObj client){
        UserEntity user = new UserEntity();
        user = userService.getName(client.getUser());
        if(user!=null){
            return new ResponseEntity<>("User already exists!", HttpStatus.I_AM_A_TEAPOT);
        }
        user.setName(client.getUser());
        user.setId(client.getId());
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully!", HttpStatus.OK);
    }
    @PutMapping(
            value = "/updateUser", consumes = "application/json", produces = "application/json"
    )
    public ResponseEntity<Object> updateUser(@RequestParam String old_user, String new_user){

        return null;
    }
}
