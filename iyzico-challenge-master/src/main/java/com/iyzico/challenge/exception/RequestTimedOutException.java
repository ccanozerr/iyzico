package com.iyzico.challenge.exception;

@SuppressWarnings("serial")
public class RequestTimedOutException extends RuntimeException{
	
	public RequestTimedOutException() {
		super();
	}

	public RequestTimedOutException(String message) {
		super(message);
	}

}
