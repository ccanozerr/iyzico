package com.iyzico.challenge.exception;

@SuppressWarnings("serial")
public class ProductCouldNotBeSoldMoreThanStockException extends RuntimeException{
	
	public ProductCouldNotBeSoldMoreThanStockException() {
		super();
	}

	public ProductCouldNotBeSoldMoreThanStockException(String message) {
		super(message);
	}

}
