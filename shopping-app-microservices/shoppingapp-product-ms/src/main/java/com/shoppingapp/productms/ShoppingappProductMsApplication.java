package com.shoppingapp.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingappProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappProductMsApplication.class, args);
	}

}
