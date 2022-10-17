package com.wenance.coreapi.v2.exception;

public class UnknownBrandException extends NonReprocessableException {
    public UnknownBrandException(String name) {
        super("Could not find brand with name: " + name);
    }
}