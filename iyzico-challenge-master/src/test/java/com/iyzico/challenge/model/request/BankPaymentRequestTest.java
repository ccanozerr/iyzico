package com.iyzico.challenge.model.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class BankPaymentRequestTest {
	
	@Test
	public void it_should_convert_to_string_properly() {

		BankPaymentRequest request = new BankPaymentRequest();
		request.setPrice(new BigDecimal(1995));
		
		BigDecimal price = new BigDecimal(1995);

		assertThat(price).isEqualTo(request.getPrice());
	}

}
