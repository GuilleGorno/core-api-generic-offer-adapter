package com.wenance.coreapi.v1.exception;

public class JsonPropertyNotFoundException extends RuntimeException {

	public JsonPropertyNotFoundException(String message) {
		super(message);
	}
}
