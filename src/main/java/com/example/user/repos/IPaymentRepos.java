package com.example.user.repos;

import com.example.user.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPaymentRepos extends MongoRepository<Payment, String> {

}
