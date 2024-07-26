package com.freshGoodies.userstories.product.service;

import com.freshGoodies.userstories.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(long id);

    List<Product> searchProduct(String name);

    Product updateProduct(Product product);
    String deleteProductById(long id);
}
