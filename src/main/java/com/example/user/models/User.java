package com.example.user.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "User")
public class User {


    @Id
    private String userId;
    private String name;
    private String email;
    private String password;
/*    private String address;*/
    private String mobileNo;

    public User(String userId, String name, String email,
                String password, /*String address,*/ String mobileNo) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
       // this.address = address;
        this.mobileNo = mobileNo;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 /*   public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
               /* ", address='" + address + '\'' +*/
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
