package com.example.UserService;

import com.example.UserService.external.services.RatingService;
import com.example.UserService.modal.Rating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating(){
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("Overall Best").build();
//		Rating savedRating = ratingService.createRating(rating);
//
//		System.out.println("new rating");
//	}
}
