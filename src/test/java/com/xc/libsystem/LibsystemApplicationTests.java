package com.xc.libsystem;

import com.xc.libsystem.Controller.UserController;
import com.xc.libsystem.Entity.User;
import com.xc.libsystem.Repository.UserRepository;
import com.xc.libsystem.Service.UserService;
import com.xc.libsystem.Util.LoginResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibsystemApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() {
        User user = userRepository.findById(1).orElse(null);
        System.out.println(user.getUsername());
    }

    @Test
    public void UserLoginTest() {
        User user = new User();
        user.setAccount("x3408");
        user.setPassword("123");
        LoginResult login = userController.login(user);
        System.out.println(login.getObject());
    }

    @Test
    public void getUser() {
        User one = userService.getUser(1);
        System.out.println(one.getUsername());
    }
}
