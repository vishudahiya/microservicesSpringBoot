package com.example.UserService.service;

import com.example.UserService.external.services.HotelService;
import com.example.UserService.modal.Hotel;
import com.example.UserService.modal.Rating;
import com.example.UserService.modal.User;
import com.example.UserService.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;



    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User getUser(UUID id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/userRating/" + user.getId(), Rating[].class);
            logger.info("{}", ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
//           ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/all/"+rating.getHotelId(), Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);
           return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(UUID id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
