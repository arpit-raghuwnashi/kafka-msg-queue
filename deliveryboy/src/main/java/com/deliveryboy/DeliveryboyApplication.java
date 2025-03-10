package com.deliveryboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com")
public class DeliveryboyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryboyApplication.class, args);
	}

}
