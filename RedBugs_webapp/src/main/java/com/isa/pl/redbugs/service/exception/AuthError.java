package com.isa.pl.redbugs.service.exception;

import lombok.Data;

import java.util.Date;

@Data
public class AuthError {
    private int status;
    private String message;
    private Date timestamp;

    public AuthError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
