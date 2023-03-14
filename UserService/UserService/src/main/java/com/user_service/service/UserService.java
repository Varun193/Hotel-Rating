package com.user_service.service;

import com.user_service.entites.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    void deleteById(String id);

    User updateUser (User user);

}
