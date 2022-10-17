package com.wenance.coreapi.v2.exception;

public class UnknownStatusException extends NonReprocessableException {
    public UnknownStatusException(String name) {
        super("Could not find status with name: " + name);
    }
}