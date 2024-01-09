package com.shoppingapp.orderms.dto;


import com.shoppingapp.orderms.model.CartItem;

import java.util.List;

public record CartDetails(List<CartItem> items, float totalCartValue) {

}
