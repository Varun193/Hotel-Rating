package com.ratingService.controller;

import com.ratingService.entites.Rating;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> allRating = ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(allRating);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("userId") String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserid(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelid(hotelId));
    }

}
