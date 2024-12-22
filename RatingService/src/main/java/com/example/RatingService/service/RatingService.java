package com.example.RatingService.service;

import com.example.RatingService.modal.Rating;
import com.example.RatingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Rating create(Rating rating){
        return ratingRepo.save(rating);
    }

    public List<Rating> getRatings(){
        return ratingRepo.findAll();
    }

    public List<Rating> getRatingByUserId(String userId){
        return ratingRepo.findByUserId(userId);
    }

    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepo.findByHotelId(hotelId);
    }
}
