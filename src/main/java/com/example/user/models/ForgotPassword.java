package com.example.user.models;

import lombok.Data;

@Data
public class ForgotPassword {

    private String email;

    public ForgotPassword() {

    }

    public ForgotPassword(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
