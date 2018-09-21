package com.xc.libsystem.Controller;

import com.xc.libsystem.Entity.User;
import com.xc.libsystem.Service.UserService;
import com.xc.libsystem.Util.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user;
    }

    @PostMapping(value = "/user")
    public LoginResult login(User user) {
        return userService.login(user);
    }
}
