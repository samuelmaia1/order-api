package com.samuelmaia1.github.orderapi.response;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private Integer status;
    private String error;
    private LocalDateTime time;

    public ErrorResponse(String message, Integer status, String error, LocalDateTime time) {
        this.message = message;
        this.status = status;
        this.error = error;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
