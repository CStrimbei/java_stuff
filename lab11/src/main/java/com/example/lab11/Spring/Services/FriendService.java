package com.example.lab11.Spring.Services;

import com.example.lab11.Entities.FriendEntity;
import com.example.lab11.Entities.UserEntity;
import com.example.lab11.Spring.Repos.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    private FriendRepo friendRepo;
    @Autowired public FriendService(FriendRepo friendRepo){
        this.friendRepo = friendRepo;
    }
    public void addFriend(FriendEntity friend){
        friendRepo.save(friend);
    }
    public boolean checkFriend(int id1, int id2){
        if(friendRepo.areFriends(id1, id2)==null){
            return false;
        }
        return true;
    }
}
