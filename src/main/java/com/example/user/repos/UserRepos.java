package com.example.user.repos;


import com.example.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepos extends MongoRepository<User, String> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
