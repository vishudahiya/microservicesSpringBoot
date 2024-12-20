package com.example.HotelService.service;

import com.example.HotelService.modal.Hotel;
import com.example.HotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    public ResponseEntity<List<Hotel>> getAllHotel() {
        return new ResponseEntity<>(hotelRepo.findAll(), HttpStatus.FOUND);
    }

    public ResponseEntity<Hotel> getById(UUID id) {
        return new ResponseEntity<>(hotelRepo.findById(id).get(), HttpStatus.ACCEPTED);
    }

    public Hotel saveHotel(Hotel hotel) {
       return hotelRepo.save(hotel);
    }

    public void deleteHotel(UUID id) {
        hotelRepo.deleteById(id);
    }

    public Hotel updateHotel(UUID id, Hotel hotel) {
        if(id == null){
            return hotel;
        }
        else {
            hotelRepo.findById(id);
            return hotelRepo.save(hotel);
        }

    }
}
