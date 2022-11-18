package com.example.user.repos;

import com.example.user.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVehicleRepos extends MongoRepository<Vehicle, String> {

}