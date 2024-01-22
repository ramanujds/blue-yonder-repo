package com.mywebfluxapp.cartservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private final String PRODUCT_SERVICE_URL="http://localhost:5100/api/products";

    private final String PRODUCT_SERVICE_LOAD_BALANCED_URL="http://PRODUCT-SERVICE/api/products";

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().baseUrl(PRODUCT_SERVICE_URL).build();
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder(){
        return WebClient.builder().baseUrl(PRODUCT_SERVICE_LOAD_BALANCED_URL);
    }


}
