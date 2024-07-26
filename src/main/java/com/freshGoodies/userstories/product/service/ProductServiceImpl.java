package com.freshGoodies.userstories.product.service;

import com.freshGoodies.userstories.product.entity.Product;
import com.freshGoodies.userstories.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty()){
            throw new RuntimeException("Product with ID: " + id + " is not available");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> searchProduct(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Product updateProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public String deleteProductById(long id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Product is not available to delete");
        }
        repository.deleteById(id);
        return "Delete successfully";
    }
}
