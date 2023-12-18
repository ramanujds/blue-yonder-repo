package com.shoppingapp.cartms.dto;

import com.shoppingapp.cartms.model.CartItem;

import java.util.List;

public record CartDetails(List<CartItem> items, float totalCartValue) {

}
