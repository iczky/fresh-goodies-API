package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.entity.Cart;
import com.freshGoodies.userstories.cart.entity.CartItem;
import com.freshGoodies.userstories.dto.CartItemDto;

import java.util.List;

public interface CartService {
    CartItemDto addCart(CartItem cartItem);
    void deleteCart(Long id);
}
