package com.example.user.service;

import com.example.user.models.Login;
import com.example.user.models.User;
import com.example.user.repos.UserRepos;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * This Class is used to perform database operations for User controller
 */
@AllArgsConstructor
@Service
public class UserService {

    /**
     * For debugging purpose
     */
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * Reference variable to handle user repos
     */
    private final UserRepos mUserRepos;


    /**
     * Map to maintain reset password operation
     */
    private static final HashMap<String, String> resetPasswordMap = new HashMap<>();

    public User create(User user) {

        return mUserRepos.save(user);
    }

    public List<User> getAllList() {
        return mUserRepos.findAll();
    }

    public void remove(String id) {
        mUserRepos.deleteById(id);
    }

    public User update(User user) {
        Optional<User> user1 = mUserRepos.findById(user.getUserId());
        if (user1.isPresent()) {
            User trainee2 = user1.get();
            trainee2.setUserId(user.getUserId());
            return mUserRepos.save(trainee2);
        } else {
            return mUserRepos.save(user);
        }
    }

    public User getUserDetails(String id) {
        Optional<User> user = mUserRepos.findById(id);
        return user.orElse(null);
    }

    public void deleteAll() {
        mUserRepos.deleteAll();
    }

    public List<User> getUserList(int startIndex, int size, int sort) {
        int totalSize = mUserRepos.findAll().size();
        int pageLastIndex = startIndex + size;
        Sort sortOrder = Sort.by(Sort.Order.asc("userId"));
        if (sort == Util.DESC) {
            sortOrder = Sort.by(Sort.Order.desc("userId"));
        }
        ///logger.info("totalSize::" + totalSize + " ,pageLastIndex::" + pageLastIndex + " ,startIndex::" + startIndex);
        if (startIndex > totalSize) {
            return new ArrayList<>();
        }
        if (pageLastIndex > totalSize) {
            return mUserRepos.findAll(sortOrder).subList(startIndex, totalSize);
        } else {
            return mUserRepos.findAll(sortOrder).subList(startIndex, pageLastIndex);
        }
    }

    public User login(Login login) {
        return mUserRepos.findByEmailAndPassword(login.getEmail(), login.getPassword());
    }

    public long getCount() {
        return mUserRepos.count();
    }

    public boolean isEmailExists(String email) {
        User trainee = mUserRepos.findByEmail(email);
        return trainee != null;
    }


    public void generateToken(String token, String email) {
        resetPasswordMap.put(token, email);
    }

    public boolean updatePassword(String token, String password) {
        boolean isUpdatePassword = false;
        String email = resetPasswordMap.get(token);
        if (email != null) {
            User user = mUserRepos.findByEmail(email);
            if (user != null) {
                user.setPassword(password);
                mUserRepos.save(user);
                isUpdatePassword = true;
            }
        }
        return isUpdatePassword;
    }
}
