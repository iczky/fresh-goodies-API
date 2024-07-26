package com.freshGoodies.userstories.cart.service.Impl;

import com.freshGoodies.userstories.cart.entity.Cart;
import com.freshGoodies.userstories.cart.entity.CartItem;
import com.freshGoodies.userstories.cart.repository.CartItemRepository;
import com.freshGoodies.userstories.cart.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private final CartItemRepository repository;

    public CartServiceImpl(CartItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public CartItem addCart(CartItem cartItem) {
        return repository.save(cartItem);
    }

    @Override
    public void deleteCart(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("The cart item with id is not available");
        }
        repository.deleteById(id);
    }
}
