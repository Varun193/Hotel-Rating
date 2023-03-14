package com.ratingService.service;

import com.ratingService.entites.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getRatingByUserid(String userID);

    List<Rating> getRatingByHotelid(String hotelId);

}
