package com.example.UserService.external.services;

import com.example.UserService.modal.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("rating/userRating/{ratingId}")
    Rating getRating(@PathVariable String ratingId);
}
