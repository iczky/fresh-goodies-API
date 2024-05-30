package com.freshGoodies.userstories.cart.model;

import com.freshGoodies.userstories.product.model.Product;
import lombok.Data;

import java.util.Optional;

@Data
public class CartWithDetail {
    private Cart cart;
    private Optional<Product> product;
}
