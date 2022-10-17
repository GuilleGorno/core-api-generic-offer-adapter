package com.wenance.coreapi.v2.exception;

public class NonReprocessableException extends RuntimeException {
    public NonReprocessableException(String message) {
        super(message);
    }
}