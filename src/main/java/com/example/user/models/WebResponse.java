package com.example.user.models;

import org.springframework.http.HttpStatus;

public class WebResponse {
    private HttpStatus status;
    private String type;
    private Object data;
    private String message;

    public WebResponse(String type, Object data, HttpStatus status, String message) {
        this.type = type;
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public WebResponse(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus httpStatusCode) {
        this.status = httpStatusCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object object) {
        this.data = object;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "WebResponse{" +
                "status=" + status +
                ", type='" + type + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
