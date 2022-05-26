package com.example.lab11.Spring;

import com.example.lab11.Entities.FriendEntity;
import com.example.lab11.Entities.UserEntity;
import com.example.lab11.Spring.Repos.FriendRepo;
import com.example.lab11.Spring.Repos.UserRepo;
import com.example.lab11.Spring.Services.FriendService;
import com.example.lab11.Spring.Services.UserService;
import com.example.lab11.Spring.models.ClientObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class ProjectWrapper {

    private UserService userService;
    private FriendService friendService;
    @Autowired public ProjectWrapper(UserService userService, FriendService friendService){
        this.userService=userService;
        this.friendService=friendService;
    }
    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser (@RequestParam String name){
        UserEntity user = new UserEntity();
        user = userService.getName(name);
        if(user!=null){
            return new ResponseEntity<>("User already exists!", HttpStatus.I_AM_A_TEAPOT);
        }
        user = new UserEntity();
        user.setName(name);
        userService.addUser(user);
        return new ResponseEntity<>("User added successfully!", HttpStatus.OK);
    }
    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestParam String old_user, String new_user){
        UserEntity userEntity;
        userEntity = userService.getName(old_user);
        if(userEntity!=null){
            userEntity.setName(new_user);
            userService.updateUser(userEntity);
        } else return new ResponseEntity<>("Could not add user!", HttpStatus.I_AM_A_TEAPOT);
        return new ResponseEntity<>("User updated successfully!", HttpStatus.OK);
    }
    @GetMapping("/getUser")
    public ResponseEntity<UserEntity> getUser(@RequestParam String name){
        return new ResponseEntity<UserEntity>(userService.getName(name), HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<UserEntity> getUser(){
        return new ResponseEntity<UserEntity>(userService.getAllUsers(), HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestBody ClientObj client){
        UserEntity user = new UserEntity();
        user.setName(client.getUser());
        user.setId(client.getId());
        userService.deleteUser(user);
    }
    @PostMapping("/addFriendship")
        public ResponseEntity<Object> addFriendship(int id1, int id2){
           UserEntity user1 = new UserEntity();
           UserEntity user2 = new UserEntity();
           user1 = userService.getId(id1);
           user2 = userService.getId(id2);
           FriendEntity friendEntity = new FriendEntity();
           friendEntity.setIdusr1(user1);
           friendEntity.setIdusr2(user2);
           friendService.addFriend(friendEntity);
           return new ResponseEntity<>("Friendship associated successfully!", HttpStatus.OK);
        }
    @GetMapping("/checkFriendship")
    public ResponseEntity<Object> checkFriendship(int id1, int id2){
        if(friendService.checkFriend(id1, id2)==true){
            return new ResponseEntity<>("The users are friends!", HttpStatus.OK);
        }
        return new ResponseEntity<>("The users are not friends!", HttpStatus.I_AM_A_TEAPOT);
    }
}
