package com.iyzico.challenge.model.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import com.iyzico.challenge.model.request.BankPaymentRequest;

public class BankPaymentResponseTest {
	
	@Test
	public void it_should_convert_to_string_properly() {

		BankPaymentResponse response = new BankPaymentResponse("400");
		
		String resultCode = "400";

		assertThat(resultCode).isEqualTo(response.getResultCode());
	}

}
