package com.example.UserService.external.services;

import com.example.UserService.modal.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("rating/userRating/{ratingId}")
    Rating getRating(@PathVariable String ratingId);

    @PostMapping("/rating/create/")
    public Rating createRating(Rating values);

    @PutMapping("/rating/{ratingId}")
    public Rating updateRating(@PathVariable String ratingId, Rating rating);

    @DeleteMapping("/delete/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
