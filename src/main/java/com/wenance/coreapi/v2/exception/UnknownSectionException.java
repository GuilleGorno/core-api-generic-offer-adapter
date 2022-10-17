package com.wenance.coreapi.v2.exception;

public class UnknownSectionException extends NonReprocessableException {
    public UnknownSectionException(String name) {
        super("Could not find section with name: " + name);
    }
}