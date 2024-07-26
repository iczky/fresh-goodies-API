package com.freshGoodies.userstories.cart.service.Impl;

import com.freshGoodies.userstories.cart.dto.CartItemDto;
import com.freshGoodies.userstories.cart.entity.CartItem;
import com.freshGoodies.userstories.cart.repository.CartItemRepository;
import com.freshGoodies.userstories.cart.service.CartService;
import com.freshGoodies.userstories.exceptions.CartNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public String deleteCart(Long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("The cart item with id is not available");
        }
        repository.deleteById(id);
        return "Deleted cart item with id " + id;
    }

    @Override
    public CartItemDto getCart(Long id) {
        Optional<CartItem> cartItemOpt = repository.findById(id);
        if (cartItemOpt.isEmpty()){
            throw new CartNotFoundException("The cart item with id " + id + " is not available");
        }
        CartItem cartItem = cartItemOpt.get();

        return CartItemDto.fromCartItem(cartItem);

    }
}
