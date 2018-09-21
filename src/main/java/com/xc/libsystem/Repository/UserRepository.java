package com.xc.libsystem.Repository;

import com.xc.libsystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("FROM User where account = ?1 and password = ?2")
//    User login(User user);

    User findUserByAccountAndPassword(String account, String password);
}
