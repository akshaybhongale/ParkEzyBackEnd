package com.example.user.repos;

import com.example.user.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITransactionRepos extends MongoRepository<Transaction, String> {
    List<Transaction> findByVehicleId(String vehicleId);
}