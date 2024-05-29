package com.freshGoodies.userstories.cart.model;

import com.freshGoodies.userstories.product.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Setter;

import java.util.Optional;

@Data
public class Cart {
    private long id;

    @NotNull
    @NotBlank(message = "ProductId must be input")
    private long productId;

    @NotBlank(message = "Quantity must be input")
    private int quantity;

    private Optional<Product> product;

}
