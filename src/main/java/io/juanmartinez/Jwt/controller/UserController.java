package io.juanmartinez.Jwt.controller;

import io.juanmartinez.Jwt.model.User;
import io.juanmartinez.Jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
@Autowired
    UserService service;
    @PostMapping("/register")
    public String register (@RequestBody User user){

        return service.register(user);
    }
    @PostMapping("/login")
    public String  login (@RequestBody User user){
        System.out.println(user);
        return service.verify(user);
    }
}
