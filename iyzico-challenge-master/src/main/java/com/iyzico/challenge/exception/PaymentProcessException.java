package com.iyzico.challenge.exception;

@SuppressWarnings("serial")
public class PaymentProcessException extends RuntimeException{
	
	public PaymentProcessException() {
		super();
	}

	public PaymentProcessException(String message) {
		super(message);
	}

}
