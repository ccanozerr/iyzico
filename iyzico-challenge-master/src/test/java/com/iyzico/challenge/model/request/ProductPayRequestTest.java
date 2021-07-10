package com.iyzico.challenge.model.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class ProductPayRequestTest {
	
	@Test
	public void it_should_convert_to_string_properly() {

		ProductPayRequest request = new ProductPayRequest();
		request.setPrice(new BigDecimal(1995));
		request.setProductId(1L);
		request.setSoldStock(1000L);

		String requestStringValue = request.toString();

		assertThat(requestStringValue).isEqualTo("ProductPayRequest [price=1995, soldStock=1000, productId=1]");
	}

}
