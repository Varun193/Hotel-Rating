package com.user_service.service.impl;

import com.netflix.discovery.converters.Auto;
import com.user_service.entites.User;
import com.user_service.repo.UserRepo;
import com.user_service.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

//    private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


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
    public User getUserById(String userId) {


        //http://localhost:8083/ratings/users/d083c5e1-8e9f-41ed-95e2-f041492c543e
        User user = userRepo.findById(userId).get();
        //invoking rating service to get rating of particular user by Userid
        ArrayList ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getId(), ArrayList.class);
        System.out.println(ratings.toString());
        user.setRating(ratings);
        return user;
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
