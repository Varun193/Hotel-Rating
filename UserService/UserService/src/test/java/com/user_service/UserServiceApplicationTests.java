package com.user_service;

import com.user_service.entites.Rating;
import com.user_service.entites.User;
import com.user_service.external.service.FeignRatinginvoker;
import com.user_service.service.UserService;
import feign.Feign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@SpringBootTest
@Service
class UserServiceApplicationTests {

    @Autowired
    FeignRatinginvoker feignRatinginvoker;

    @Test
    void contextLoads() {
    }

    Rating rating = Rating.builder().userId("").ratingid("").rating(5).feedback("creaated using feign client").build();

    @Test
    void saveUser() {
        Rating newRating = feignRatinginvoker.saveRating(rating);
        System.out.println("New rating created" + rating.toString());

    }

}
