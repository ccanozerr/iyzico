package com.iyzico.challenge.entity;

import java.math.BigDecimal;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {
	
	@Test
    public void it_should_convert_to_string_properly() {
		
		Product product = new Product();
		product.setId(1L);
		product.setName("name");
		product.setDescription("description");
		product.setPrice(new BigDecimal(1995));
		product.setRemainingStockCount(1000L);

        String productStringValue = product.toString();

        assertThat(productStringValue).isEqualTo("Product [name=name, description=description, remainingStockCount=1000, price=1995]");
    }

}
