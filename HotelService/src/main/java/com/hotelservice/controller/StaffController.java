package com.hotelservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    ResponseEntity<List<String>> getStaffs() {
        List<String> staff = Arrays.asList("varun", "arpit", "Ajeet", "chandan");
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }
}
