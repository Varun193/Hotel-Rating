package com.hotelservice.controller;

import com.hotelservice.entites.Hotel;
import com.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel hotelDetail = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelDetail);
    }

    @GetMapping
    ResponseEntity<List<Hotel>> findAllHotels() {
        List<Hotel> getallHotels = hotelService.getall();
        return ResponseEntity.status(HttpStatus.OK).body(getallHotels);
    }

    @GetMapping("/{hotelId}")
    ResponseEntity<Hotel> findHotelById(@PathVariable("hotelId") String id) {
        System.out.println(id);
        Hotel getHotelById = hotelService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getHotelById);
    }
}
