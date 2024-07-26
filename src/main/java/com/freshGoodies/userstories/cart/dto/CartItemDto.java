package com.freshGoodies.userstories.cart.dto;

import com.freshGoodies.userstories.cart.entity.CartItem;
import lombok.Data;

@Data
public class CartItemDto {
    private Long id;
    private Long productId;
    private String productName;
    private int quantity;

    public static CartItemDto fromCartItem(CartItem cartItem){
        CartItemDto dto = new CartItemDto();
        dto.setId(cartItem.getId());
        dto.setProductName(cartItem.getProduct().getName());
        dto.setProductId(cartItem.getProduct().getId());
        dto.setQuantity(cartItem.getQuantity());
        return dto;
    }
}
