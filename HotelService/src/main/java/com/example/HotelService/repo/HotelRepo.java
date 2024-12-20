package com.example.HotelService.repo;

import com.example.HotelService.modal.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, UUID> {
}
