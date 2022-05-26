package com.example.lab11.Server.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> friends;
    private List<String> mesaje;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.mesaje = new ArrayList<>();
    }


    //pt adaugat prieteni in lista
    public void friendAdd(User user){
        friends.add(user);
    }
    //pt adaugat mesaje in lista
    public void mesajAdd(String mesaj){
        this.mesaje.add(mesaj);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<String> getMesaje() {
        return mesaje;
    }

    public void setMesaje(List<String> mesaje) {
        this.mesaje = mesaje;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (friends != null ? !friends.equals(user.friends) : user.friends != null) return false;
        return mesaje != null ? mesaje.equals(user.mesaje) : user.mesaje == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (friends != null ? friends.hashCode() : 0);
        result = 31 * result + (mesaje != null ? mesaje.hashCode() : 0);
        return result;
    }
}
