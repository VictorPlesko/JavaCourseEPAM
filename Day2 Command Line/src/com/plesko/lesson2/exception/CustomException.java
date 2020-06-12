package com.plesko.lesson2.exception;

public class CustomException extends Exception {

    public CustomException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
