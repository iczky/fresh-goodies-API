package com.freshGoodies.userstories.cart.service.Impl;

import com.freshGoodies.userstories.cart.entity.Cart;
import com.freshGoodies.userstories.cart.entity.CartItem;
import com.freshGoodies.userstories.cart.service.CartService;
import com.freshGoodies.userstories.dto.CartItemDto;
import com.freshGoodies.userstories.exceptions.ProductNotFoundException;
import com.freshGoodies.userstories.product.entity.Product;
import com.freshGoodies.userstories.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public CartItemDto addCart(CartItem cartItem) {
        return null;
    }

    @Override
    public void deleteCart(Long id) {

    }
}
