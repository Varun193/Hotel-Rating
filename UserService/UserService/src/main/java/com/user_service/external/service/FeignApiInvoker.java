package com.user_service.external.service;

import com.user_service.entites.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "HOTEL-SERVICE")
public interface FeignApiInvoker {

          @RequestMapping(method = RequestMethod.GET, value = "/hotels/{hotelId}")
          Hotel getHotelByid(@PathVariable("hotelId") String hotelId);

}
