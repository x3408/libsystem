package com.xc.libsystem.Service;

import com.xc.libsystem.Entity.User;
import com.xc.libsystem.Repository.UserRepository;
import com.xc.libsystem.Util.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public LoginResult login(User user) {
//        User login = userRepository.login(user);
        User login = userRepository.findUserByAccountAndPassword(user.getAccount(), user.getPassword());
        if (login == null) {
            return LoginResult.failLogin();
        }

        return LoginResult.success(login);
    }

    public User getUser(Integer id) {
        User one = userRepository.findById(id).orElse(null);
        return one;
    }
}
