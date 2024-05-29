package com.freshGoodies.userstories.cart.service.Impl;

import com.freshGoodies.userstories.cart.model.Cart;
import com.freshGoodies.userstories.cart.service.CartService;
import com.freshGoodies.userstories.product.service.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CartServiceImpl implements CartService {
    List<Cart> carts = new ArrayList<>();
    AtomicLong counter = new AtomicLong();

    @Override
    public List<Cart> addCart(Cart cart){
        boolean exist = carts.stream().anyMatch(c -> c.getId() == cart.getId());

        if (!exist || )
    }

}
