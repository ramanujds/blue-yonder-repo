package com.mywebfluxapp.cartservice.service;

import com.mywebfluxapp.cartservice.dto.CartDetailsDto;
import com.mywebfluxapp.cartservice.dto.CartItemDto;
import com.mywebfluxapp.cartservice.dto.ProductApiResponse;
import com.mywebfluxapp.cartservice.model.CartItemEntity;
import com.mywebfluxapp.cartservice.repository.CartItemRepository;
import com.mywebfluxapp.cartservice.util.EntityDtoUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CartItemServiceImpl implements CartItemService{

   private WebClient.Builder productServiceClientBuilder;

   private CartItemRepository cartItemRepository;




   @Autowired
    public CartItemServiceImpl(WebClient.Builder productServiceClient, CartItemRepository cartItemRepository) {
        this.productServiceClientBuilder = productServiceClient;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Mono<CartItemDto> addCartItem(int productId, int quantity) {
      return productServiceClientBuilder.build().get()
                .uri("/{id}",productId)
                .retrieve()
                .bodyToMono(ProductApiResponse.class)
                .map(productApiResponse -> new CartItemEntity(0,productApiResponse.name(),productApiResponse.price(),quantity))
                .flatMap(cartItemRepository::save)
                .map(EntityDtoUtil::getCartItemDto)
       //         .retryWhen(Retry.fixedDelay(3, Duration.ofSeconds(1)))
              .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)))

              ;

    }

    public Mono<CartDetailsDto> getAllCartItems() {

        return cartItemRepository.findAll()
                .collectList()
                .map(cartItemEntities -> {
                    float total = 0;
                    List<CartItemDto> cartItemDtos = new ArrayList<>();
                    for (CartItemEntity cartItemEntity : cartItemEntities) {
                        total += cartItemEntity.getPrice() * cartItemEntity.getQuantity();
                        cartItemDtos.add(EntityDtoUtil.getCartItemDto(cartItemEntity));
                    }

                    return new CartDetailsDto(cartItemDtos, total);
                });

    }


}
