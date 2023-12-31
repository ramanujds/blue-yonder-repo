package com.shoppingapp.cartms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingappCartMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappCartMsApplication.class, args);
	}

}
