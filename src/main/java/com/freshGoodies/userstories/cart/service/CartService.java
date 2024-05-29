package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.model.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);
    List<Cart> getCartDetail();
    Cart updateCart(long id, Cart newCart);

    Cart deleteCart(long id);
}
