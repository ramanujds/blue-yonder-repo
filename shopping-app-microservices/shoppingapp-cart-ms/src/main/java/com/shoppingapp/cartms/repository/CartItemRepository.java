package com.shoppingapp.cartms.repository;

import com.shoppingapp.cartms.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{


}
