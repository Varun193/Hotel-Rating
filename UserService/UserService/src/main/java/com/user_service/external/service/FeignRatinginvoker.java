package com.user_service.external.service;

import com.user_service.entites.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface FeignRatinginvoker {

    @RequestMapping(method = RequestMethod.POST, value = "/ratings")
    List<Rating> saveRating(@RequestBody Rating rating);  //during runtime implementation will be provided.

    @RequestMapping(method = RequestMethod.GET, value="/users/{userId}")
    Rating getRatingByUserId(@PathVariable("userId") String userId);
}
