package com.example.dynamodb.exception;

public class UnavailableBookException extends RuntimeException {
    public UnavailableBookException(String message) {
        super(message);
    }
}
