package com.hotelservice.services;

import com.hotelservice.entites.Hotel;
import com.hotelservice.exceptions.ResourceNotFoundException;
import com.hotelservice.repo.Hotelrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private Hotelrepo hotelrepo;

    @Override
    public Hotel save(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelrepo.save(hotel);
    }

    @Override
    public List<Hotel> getall() {
        List<Hotel> hotels = hotelrepo.findAll();
        return hotels;
    }

    @Override
    public Hotel getById(String id) {
        return hotelrepo.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("hotel with given by not found");
        });
    }
}
