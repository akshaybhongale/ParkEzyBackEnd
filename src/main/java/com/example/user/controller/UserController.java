package com.example.user.controller;

import com.example.user.models.*;
import com.example.user.service.UserService;
import com.example.user.utils.Util;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Rest controller for executing user operation related REST API
 */
@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    /**
     * Reference variable for user service
     */
    private final UserService mUserService;


    /**
     * This method is used to accept user details from client for registration purpose
     *
     * @param user User details for registration
     * @return result of registration operation
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody User user) {
        User user1 = mUserService.create(user);

        WebResponse webResponse = new WebResponse("object", user1,
                HttpStatus.OK, "registered user details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to update user details for given user object
     *
     * @param user user details for update
     * @return result of user operations
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<Object> update(
            @RequestBody User user) {
        mUserService.update(user);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated user details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to delete user from database
     *
     * @param userId user to be deleted
     * @return result of delete operation
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("userId") String userId) {
        mUserService.remove(userId);
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "deleted user successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to get list all register use
     *
     * @return list of register user
     */
    @GetMapping
    public ResponseEntity<Object> getList() {
        WebResponse webResponse = new WebResponse("array", mUserService.getAllList(),
                HttpStatus.OK, "fetched details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    /**
     * This method is used to get register user details
     *
     * @param userId user id
     * @return user details in response
     */
    @RequestMapping(value = "/getUserDetails/{userId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserDetails(@PathVariable("userId") String userId) {
        User user = mUserService.getUserDetails(userId);
        WebResponse webResponse;
        if (user != null) {
            webResponse = new WebResponse("object", user,
                    HttpStatus.OK, "details fetched successfully");
        } else {
            webResponse = new WebResponse("object", "",
                    HttpStatus.OK, "no record found");
        }
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    /**
     * This method is used to get registered user list
     *
     * @param index starting index
     * @param size  size of page
     * @param sort  sorting order
     * @return list of registered user
     */
    @RequestMapping(value = "/getUserList", params = {"startIndex", "size", "sort"}, method = RequestMethod.GET)
    public ResponseEntity<Object> getTraineeList(@RequestParam("startIndex") int index,
                                                 @RequestParam("size") int size,
                                                 @RequestParam("sort") int sort) {
        WebResponse webResponse = new WebResponse("array", mUserService.getUserList(index, size, sort),
                HttpStatus.OK, "fetch details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to delete all user from database
     *
     * @return result of operations
     */
    @RequestMapping(value = "/deleteAll/", method = RequestMethod.GET)
    public ResponseEntity<Object> deleteAll() {
        mUserService.deleteAll();
        WebResponse webResponse = new WebResponse("object", mUserService.getAllList(),
                HttpStatus.OK, "deleted  details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }


    /**
     * This method is used to perform login for given login  credentials
     *
     * @param login login details of user
     * @return user details of logged in user
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Login login) {
        User user = mUserService.login(login);
        WebResponse webResponse;
        if (user == null) {
            webResponse = new WebResponse("object", "",
                    HttpStatus.OK, "invalid emailId or password");
        } else {
            webResponse = new WebResponse("object", user,
                    HttpStatus.OK, "welcome to home");
        }

        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to return total count of registered user in database
     *
     * @return count of user
     */
    @RequestMapping(value = "/getCount", method = RequestMethod.GET)
    public ResponseEntity<Object> getCount() {
        long count = mUserService.getCount();
        WebResponse webResponse = null;
        webResponse = new WebResponse("object", count,
                HttpStatus.OK, "");

        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to request for forgot password
     *
     * @param forgotPassword register email id for resetting password
     * @return instruction of reset password
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> forgotPassword(@RequestBody ForgotPassword forgotPassword) {
        boolean isExits = mUserService.isEmailExists(forgotPassword.getEmail());
        WebResponse webResponse = null;
        if (isExits) {
            String token = Util.getRandomToken();
            mUserService.generateToken(token, forgotPassword.getEmail());
            ForgotPasswordResponse forgotPasswordResponse = new ForgotPasswordResponse(token);
            webResponse = new WebResponse("object", forgotPasswordResponse,
                    HttpStatus.OK,
                    "Reset password link sent successfully on registered email id");
        } else {
            webResponse = new WebResponse("object", "",
                    HttpStatus.OK, "email is not registered");
        }
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }

    /**
     * This method is used to update password for given email id
     *
     * @param resetPassword it contains new password ,token for registered email id
     * @return result of reset password
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ResponseEntity<Object> resetPassword(@RequestBody ResetPassword resetPassword) {
        boolean isUpdatePassword = mUserService.updatePassword(resetPassword.getToken(), resetPassword.getNewPassword());
        WebResponse webResponse;
        if (isUpdatePassword) {

            webResponse = new WebResponse("object", "", HttpStatus.OK,
                    "password updated successfully");
        } else {
            webResponse = new WebResponse("object", "",
                    HttpStatus.OK, "password not updated successfully");
        }
        return new ResponseEntity<>(webResponse, HttpStatus.OK);

    }


    /**
     * This method is used to update name for given email id
     *
     * @param name name to be updated
     * @return result of operations
     */
    @PutMapping(value = "/updateName/{name}")
    public ResponseEntity<Object> updateName(
            @PathVariable("name") String name) {
        WebResponse webResponse = new WebResponse("object", "",
                HttpStatus.OK, "updated details successfully");
        return new ResponseEntity<>(webResponse, HttpStatus.OK);
    }
}
