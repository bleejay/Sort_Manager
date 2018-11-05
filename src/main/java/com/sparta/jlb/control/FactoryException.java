package com.sparta.jlb.control;

public class FactoryException extends Exception {

    private String message;

    public FactoryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
