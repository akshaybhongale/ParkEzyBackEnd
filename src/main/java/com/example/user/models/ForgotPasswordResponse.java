package com.example.user.models;

import lombok.Data;

@Data
public class ForgotPasswordResponse {
    private String token;

    public ForgotPasswordResponse(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
