package com.example.user.repos;

import com.example.user.models.ParkingSpot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParkingRepos extends MongoRepository<ParkingSpot, String> {

}
