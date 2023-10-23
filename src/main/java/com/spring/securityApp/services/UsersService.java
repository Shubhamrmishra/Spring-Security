package com.spring.securityApp.services;

import com.spring.securityApp.models.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    public List<Users> usersList = new ArrayList<Users>();

    public UsersService() {
        usersList.add(new Users("abc", "abc", "abc@gmail.com"));
        usersList.add(new Users("xyz", "xyz", "xyz@gmail.com"));
    }

    public List<Users> getUsers() {
        return usersList;
    }

    public Users getUsersByUserName(String username){
        return this.usersList.stream().filter(users -> users.getUsername().equals(username)).findAny().orElseThrow(null);
    }

    public Users addUser(Users user){
        this.usersList.add(user);
        return user;
    }
}
