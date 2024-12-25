package com.example.RatingService.controller;

import com.example.RatingService.modal.Rating;
import com.example.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getRatings(){
        return new ResponseEntity<>(ratingService.getRatings(), HttpStatus.FOUND);
    }

    @GetMapping("/userRating/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.FOUND);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return new ResponseEntity<>(ratingService.create(rating), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{ratingId}")
    public String deleteById(@PathVariable String ratingId){
        ratingService.deleteById(ratingId);
        return "Deleted";
    }

}
