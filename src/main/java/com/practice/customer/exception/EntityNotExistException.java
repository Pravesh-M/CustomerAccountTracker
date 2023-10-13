package com.practice.customer.exception;

public class EntityNotExistException extends Exception {
    private String message;

    public EntityNotExistException(String message) {
        super(message);
    }
}
