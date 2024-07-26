package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.entity.Cart;
import com.freshGoodies.userstories.cart.entity.CartItem;

public interface CartService {
    CartItem addCart(CartItem cartItem);
    void deleteCart(Long id);
}
