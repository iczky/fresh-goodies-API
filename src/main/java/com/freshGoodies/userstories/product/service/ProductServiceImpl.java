package com.freshGoodies.userstories.product.service;

import com.freshGoodies.userstories.product.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();
    @Override
    public Product saveProduct(Product product) {
        boolean exists =products.stream().anyMatch(p -> p.getId() == product.getId());

        products.add(product);
    }
}
