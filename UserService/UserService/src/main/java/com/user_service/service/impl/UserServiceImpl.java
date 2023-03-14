package com.user_service.service.impl;

import com.user_service.entites.User;
import com.user_service.repo.UserRepo;
import com.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setId(randomId);
        System.out.println(user);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void deleteById(String id) {
       userRepo.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
       return userRepo.save(user);
    }

}
