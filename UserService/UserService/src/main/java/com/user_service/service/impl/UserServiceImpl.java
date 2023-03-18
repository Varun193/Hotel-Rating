package com.user_service.service.impl;

import com.netflix.discovery.converters.Auto;
import com.user_service.entites.Hotel;
import com.user_service.entites.Rating;
import com.user_service.entites.User;
import com.user_service.external.service.FeignApiInvoker;
import com.user_service.external.service.FeignRatinginvoker;
import com.user_service.repo.UserRepo;
import com.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

//    private Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);


//    Rating rating;

    @Autowired
    FeignApiInvoker feignApiInvoker;

    @Autowired
    FeignRatinginvoker feignRatinginvoker;

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setId(randomId);
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
        Rating[] ratingofUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getId(), Rating[].class);
//        System.out.println(ratings.toString());
        List<Rating> ratings = Arrays.stream(ratingofUser).collect(Collectors.toList());

        List<Rating> ratingList = ratings.stream().map(rating -> {
            System.out.println(rating.getHotelId());
            //invoke Hotel Service to get rating of particular user and map
            //http://localhost:8083/ratings/hotels/6cc93cac-3a49-408b-98d0-4ee5bf1290c7
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(), Hotel.class);
            Hotel hotel = feignApiInvoker.getHotelByid(rating.getHotelId());
            System.out.println(hotel);
//            Hotel hotel = forEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRating(ratingList);
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
