package com.freshGoodies.userstories.cart.service;

import com.freshGoodies.userstories.cart.model.Cart;
import com.freshGoodies.userstories.cart.model.CartWithDetail;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);
    List<CartWithDetail> getCartDetail();
    Cart updateCart(long id, Cart newCart);

    Cart deleteCart(long id);
}
