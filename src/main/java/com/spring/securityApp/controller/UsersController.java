package com.spring.securityApp.controller;

import com.spring.securityApp.models.Users;
import com.spring.securityApp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService service;

    @GetMapping("/")
    public List<Users> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/users/{userName}")
    public Users getUsersByUserName(@PathVariable String userName) {
        return service.getUsersByUserName(userName);
    }

    @PostMapping("/")
    public Users addUsers(@RequestBody Users users){
        return service.addUser(users);
    }

    @GetMapping("/public")
    public String getPublic(){
        return "this is public method";
    }
}
