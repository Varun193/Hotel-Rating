package com.ratingService.repo;

import com.ratingService.entites.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {

    //custom methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
