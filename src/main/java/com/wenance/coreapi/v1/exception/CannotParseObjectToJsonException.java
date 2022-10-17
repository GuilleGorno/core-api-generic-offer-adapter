package com.wenance.coreapi.v1.exception;

public class CannotParseObjectToJsonException extends RuntimeException {
    public CannotParseObjectToJsonException(String message) {
        super(message);
    }
}
