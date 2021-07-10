package com.iyzico.challenge.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.iyzico.challenge.constants.ApiErrorConstants;
import com.iyzico.challenge.model.error.ApiError;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError error = new ApiError(ex.getMessage(), ApiErrorConstants.REQUEST_METHOD_NOT_SUPPORTED,status, LocalDateTime.now());
		logger.error("Request method not supported error occured. Exception detail: {}", error.toString());
		return ResponseEntity.status(status).body(error);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError error = new ApiError(ex.getMessage(), ApiErrorConstants.HTTP_MEDIA_TYPE_NOT_SUPPORTED,status, LocalDateTime.now());
		logger.error("Http media type not supported error occured. Exception detail: {}", error.toString());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(ProductCouldNotBeSoldMoreThanStockException.class)
	public ResponseEntity<Object> handleProductCouldNotBeSoldMoreThanStockException(ProductCouldNotBeSoldMoreThanStockException ex){
		ApiError error = new ApiError(ex.getMessage(), ApiErrorConstants.PRODUCT_COULD_NOT_BE_SOLD_MORE_THAN_STOCK, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		logger.error("Product could not be sold more than stock error occured. Exception detail: {}", error.toString());
		return ResponseEntity.status(error.getStatus()).body(error);
	}

	@ExceptionHandler(PaymentProcessException.class)
	public ResponseEntity<Object> handlePaymentProcessException(PaymentProcessException ex){
		ApiError error = new ApiError(ex.getMessage(), ApiErrorConstants.AN_ERROR_OCCURRED_WHILE_PAYMENT_PROCESSED, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		logger.error("Payment processed error occured. Exception detail: {}", error.toString());
		return ResponseEntity.status(error.getStatus()).body(error);
	}
	
	@ExceptionHandler(RequestTimedOutException.class)
	public ResponseEntity<Object> handleRequestTimedOutException(RequestTimedOutException ex){
		ApiError error = new ApiError(ex.getMessage(), ApiErrorConstants.PAYMENT_REQUEST_TIMED_OUT, HttpStatus.REQUEST_TIMEOUT, LocalDateTime.now());
		logger.error("Payment request timed error occured. Exception detail: {}", error.toString());
		return ResponseEntity.status(error.getStatus()).body(error);
	}
}
