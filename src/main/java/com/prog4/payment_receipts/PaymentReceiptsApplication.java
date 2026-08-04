package com.prog4.payment_receipts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) otra forma de desactivar seguridad
public class PaymentReceiptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentReceiptsApplication.class, args);
	}

}
