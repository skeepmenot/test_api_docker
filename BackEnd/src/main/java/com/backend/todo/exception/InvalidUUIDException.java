package com.backend.todo.exception;

public class InvalidUUIDException extends RuntimeException {

    public InvalidUUIDException(String message) {
        super(message);
    }
}
