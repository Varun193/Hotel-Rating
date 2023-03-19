package com.user_service.Controller;
import com.user_service.entites.User;
import com.user_service.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

   @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        System.out.println(user.getName());
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping
    public ResponseEntity<?> finaAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        User userById = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }

    //creating ratingHotelFallback for circuit breaker
    //return type of fallback method should be same as original method

    public ResponseEntity<User> ratingHotelFallback(String id, Exception ex) {
        System.out.println("fall back is executed because service is down : " + ex.getMessage());
        User dummyResponse = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .id("12345")
                .about("service is down")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(dummyResponse);
    }

}
