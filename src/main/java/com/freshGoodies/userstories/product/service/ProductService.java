package com.freshGoodies.userstories.product.service;

import com.freshGoodies.userstories.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Optional<Product> getProductById(long id);
    List<Product> searchProduct(String name, String category);
    Product updateProduct(Product product);
    String deleteProductById(long id);

    List<Product> getProductList();
}
