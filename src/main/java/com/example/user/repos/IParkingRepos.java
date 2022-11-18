package com.example.user.repos;

import com.example.user.models.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IParkingRepos extends MongoRepository<ParkingSpot, String> {
    List<ParkingSpot> findByIsAvailable(boolean isAvailable);
}
