package com.iyzico.challenge.entity;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class PaymentTest {
	
	@Test
    public void it_should_convert_to_string_properly() {
		
		Payment payment = new Payment();
		payment.setId(1L);
		payment.setPrice(new BigDecimal(1995));
		payment.setBankResponse("bankResponse");

        String paymentStringValue = payment.toString();

        assertThat(paymentStringValue).isEqualTo("Payment [id=1, price=1995, bankResponse=bankResponse]");
    }

}
