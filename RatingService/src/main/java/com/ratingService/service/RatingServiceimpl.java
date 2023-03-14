package com.ratingService.service;

import com.ratingService.entites.Rating;
import com.ratingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceimpl implements RatingService {

    @Autowired
    RatingRepo ratingRepo;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        List<Rating> ratings = ratingRepo.findAll();
        return  ratings;
    }

    @Override
    public List<Rating> getRatingByUserid(String userID) {
        List<Rating> ratingByUserId = ratingRepo.findByUserId(userID);
        return ratingByUserId;
    }

    @Override
    public List<Rating> getRatingByHotelid(String hotelId) {
        List<Rating> RatingByHotelId = ratingRepo.findByHotelId(hotelId);
        return RatingByHotelId;
    }
}
