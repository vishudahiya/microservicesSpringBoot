package com.example.HotelService.controller;

import com.example.HotelService.modal.Hotel;
import com.example.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAll(){
        return hotelService.getAllHotel();
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable UUID id){
        return hotelService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public Hotel updateHotel(@PathVariable UUID id, @RequestBody Hotel hotel){
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable UUID id){
        hotelService.deleteHotel(id);
        return "Deleted";
    }
}
