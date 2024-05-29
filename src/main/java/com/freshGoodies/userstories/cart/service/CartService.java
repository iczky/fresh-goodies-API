package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> addCart(Cart cart);
}
