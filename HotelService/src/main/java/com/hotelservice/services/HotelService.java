package com.hotelservice.services;


import com.hotelservice.entites.Hotel;

import java.util.List;

public interface HotelService {
    //create
    Hotel save(Hotel hotel);

    //get all
    List<Hotel> getall();

    //get by id
    Hotel getById(String id);

}
