package com.wenance.coreapi.v2.exception;

public class UnknownProductException extends NonReprocessableException {
    public UnknownProductException(String name) {
        super("Could not find product with name: " + name);
    }
}