package com.example.lab11.Server.model;

import java.util.ArrayList;
import java.util.List;

public class UserSystem {
    private static List<User> userList = new ArrayList<>();

    public static void addUsertoList(User user){
        userList.add(user);
    }

    public static List<User> getUserList() {
        return userList;
    }

}
