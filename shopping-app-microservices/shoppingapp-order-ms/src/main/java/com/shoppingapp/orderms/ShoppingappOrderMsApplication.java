package com.shoppingapp.orderms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ShoppingappOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappOrderMsApplication.class, args);
	}

}
