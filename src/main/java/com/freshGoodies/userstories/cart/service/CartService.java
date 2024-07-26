package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.dto.CartItemDto;
import com.freshGoodies.userstories.cart.entity.CartItem;

public interface CartService {
    CartItem addCart(CartItem cartItem);
    String deleteCart(Long id);
    CartItemDto getCart(Long id);
}
