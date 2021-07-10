package com.iyzico.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.constants.ApiEndPoints;
import com.iyzico.challenge.exception.ProductCouldNotBeSoldMoreThanStockException;
import com.iyzico.challenge.model.request.ProductPayRequest;
import com.iyzico.challenge.service.IyzicoPaymentService;
import com.iyzico.challenge.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping(value = ApiEndPoints.IYZICO__PRODUCT_API, produces = ApiEndPoints.RESPONSE_CONTENT_TYPE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "iyzico-payment-api", description = "Iyzico Payment Api")
})
public class PaymentController {
	
private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private final ProductService productService;
	private final IyzicoPaymentService paymentService;
	
	public PaymentController(ProductService productService, IyzicoPaymentService paymentService) {
		this.productService = productService;
		this.paymentService = paymentService;
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Pay the Product", notes = "Pay the Product")
    public void pay(@RequestBody ProductPayRequest request){
		
    	logger.info("Paying product started for request: {}", request);
    	
    	boolean isProductStockEnabled = productService.isProductStockEnabled(request.getProductId(), request.getSoldStock());
    	
    	if(isProductStockEnabled)
    		paymentService.pay(request.getPrice());
    	else
    		throw new ProductCouldNotBeSoldMoreThanStockException("A product should not be sold for more than its stock");
    }
	
}
