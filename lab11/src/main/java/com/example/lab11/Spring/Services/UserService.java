package com.example.lab11.Spring.Services;

import com.example.lab11.Entities.UserEntity;
import com.example.lab11.Spring.Repos.UserRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class UserService {
    private UserRepo userRepo;
    @Autowired
    public UserService (UserRepo userRepo){
        this.userRepo = userRepo;
    }
    public UserEntity getName(String name){
        return userRepo.findName(name);
    }
    public UserEntity getId(int id){
        return userRepo.findId(id);
    }
    public UserEntity getAllUsers(){
        return userRepo.findAllIds();
    }
    public void addUser(UserEntity user){
        userRepo.save(user);
    }
    public void updateUser(UserEntity user){
        userRepo.save(user);
    }
    public void deleteUser(UserEntity user){
        userRepo.delete(user);
    }

}
