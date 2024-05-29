package com.freshGoodies.userstories.cart.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Cart {
    private long id;

    @NotNull
    @NotBlank(message = "ProductId must be input")
    private long productId;

    @NotBlank(message = "Quantity must be input")
    private int quantity;
}
