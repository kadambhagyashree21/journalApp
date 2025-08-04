package com.bkgroup.journalApp.controller;

import com.bkgroup.journalApp.entity.Email;
import com.bkgroup.journalApp.entity.User;
import com.bkgroup.journalApp.services.EmailService;
import com.bkgroup.journalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public User addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.addUser(user);

    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();

    }

    @PostMapping("/mail")
    public void senEmail(@RequestBody Email email){
        emailService.sendEmail(email.getTo(),email.getSubject(),email.getBody());
    }
}
