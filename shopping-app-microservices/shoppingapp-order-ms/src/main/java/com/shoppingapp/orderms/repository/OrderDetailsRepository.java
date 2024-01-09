package com.shoppingapp.orderms.repository;

import com.shoppingapp.orderms.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
