package com.wenance.coreapi.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SectionNotFoundException extends ResponseStatusException {
    private static final long serialVersionUID = -3504529315392988370L;

    public SectionNotFoundException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public SectionNotFoundException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    public SectionNotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }

    public SectionNotFoundException(Exception notFound) {
        super(HttpStatus.NOT_FOUND, notFound.getMessage());
    }
}
