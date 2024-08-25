package io.juanmartinez.Jwt.service;

import io.juanmartinez.Jwt.model.User;
import io.juanmartinez.Jwt.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User register (User user){
        //this is how you encode the password using spring security
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);

    };
}
