package com.iyzico.challenge.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iyzico.challenge.constants.ApiEndPoints;
import com.iyzico.challenge.model.dto.ProductDTO;
import com.iyzico.challenge.model.request.ProductCreateRequest;
import com.iyzico.challenge.model.request.ProductUpdateRequest;
import com.iyzico.challenge.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping(value = ApiEndPoints.IYZICO_PRODUCT_API, produces = ApiEndPoints.RESPONSE_CONTENT_TYPE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
@Api
@SwaggerDefinition(tags = {
        @Tag(name = "iyzico-product-api", description = "Iyzico Product Api")
})
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create Product", notes = "Create Product")
    public ProductDTO createProduct(@RequestBody ProductCreateRequest request){
    	logger.info("Creating product started for request: {}", request);
        return service.createProduct(request);
    }
	
	@PutMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update Product", notes = "Update Product")
    public ProductDTO updateProduct(@RequestBody ProductUpdateRequest request){
    	logger.info("Updating product started for request: {}", request);
        return service.updateProduct(request);
    }
	
	@DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete Product", notes = "Delete Product")
    public boolean deleteProduct(@PathVariable Long id){
    	logger.info("Updating product started for product id: {}", id);
        return service.deleteProduct(id);
    }
	
	@GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get Product List", notes = "Get Product List")
    public List<ProductDTO> getProductList(){
    	logger.info("Get product list started");
        return service.getProductList();
    }

}
