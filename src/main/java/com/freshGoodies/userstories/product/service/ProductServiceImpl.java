package com.freshGoodies.userstories.product.service;

import com.freshGoodies.userstories.exceptions.ProductNotFoundException;
import com.freshGoodies.userstories.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    @Override
    public Product saveProduct(Product product) {
        boolean exists =products.stream().anyMatch(p -> Objects.equals(p.getId(), product.getId()));
        if (exists){
            throw new RuntimeException("Product with ID: " + product.getId() + " Already Exist");
//            return Response.failedResponse(HttpStatus.CONFLICT.value(), "Product ID is already exist", null);
        }
        product.setId(counter.incrementAndGet());
        products.add(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct(){
        return products;
    }

    @Override
    public Optional<Product> getProductById(long id){
        var foundProduct =  products.stream().filter(product -> product.getId().equals(id)).findFirst();
        if (foundProduct.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        return foundProduct;
    }

    @Override
    public List<Product> searchProduct(String name, String category){
        List<Product> filteredProduct = products.stream().filter(product ->
                        (name == null || product.getName().toLowerCase().contains(name.toLowerCase()))
                                && (category == null || product.getCategory().toLowerCase().contains(category.toLowerCase()))
                ).toList();
        if (filteredProduct.isEmpty()){
            throw new ProductNotFoundException("Product desire is not found!!");
        }
        return filteredProduct;
    }

    @Override
    public Product updateProduct(Product product){
        Product currentProduct = products.stream()
                .filter(p -> p.getId().equals(product.getId()))
                .findFirst()
                .orElse(null);

        if (currentProduct != null){
            currentProduct.setName(product.getName());
            currentProduct.setPrice(product.getPrice());
            currentProduct.setCategory(product.getCategory());
            currentProduct.setWeight(product.getWeight());
            currentProduct.setImageUrl(product.getImageUrl());
            currentProduct.setMetadata(product.getMetadata());
        } else {
            throw new ProductNotFoundException("Product is not exist!!");
        }

        return currentProduct;
    }
}
