package com.hotelservice.repo;

import com.hotelservice.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Hotelrepo extends JpaRepository<Hotel, String> {

}
