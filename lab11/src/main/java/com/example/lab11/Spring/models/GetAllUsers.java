package com.example.lab11.Spring.models;

import com.example.lab11.Server.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsers {
    List<ClientObj> usernames;
}
