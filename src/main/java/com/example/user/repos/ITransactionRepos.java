package com.example.user.repos;

import com.example.user.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITransactionRepos extends MongoRepository<Transaction, String> {

}