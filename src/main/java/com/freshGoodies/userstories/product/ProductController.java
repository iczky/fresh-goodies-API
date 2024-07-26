package com.freshGoodies.userstories.product;

import com.freshGoodies.userstories.product.entity.Product;
import com.freshGoodies.userstories.product.service.ProductService;
import com.freshGoodies.userstories.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Response<Product>> addProduct(@Valid @RequestBody Product product){
        Product savedProduct = productService.saveProduct(product);
        return Response.successResponse(HttpStatus.CREATED.value(), "New Product Added", savedProduct);
    }

    @GetMapping
    public ResponseEntity<?> searchProductByName (@RequestParam String name){
        return Response.successResponse("Fetch product that contain: " + name, productService.searchProduct(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById (@PathVariable long id){
        return Response.successResponse("Fetch product with id: " + id, productService.getProductById(id));
    }

    @PutMapping
    public ResponseEntity<Response<Product>> updateProduct (@RequestBody Product product){
        var currentProduct = productService.updateProduct(product);
        return Response.successResponse("Update successful", currentProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deleteProductById (@PathVariable long id){
        String dataMsg = productService.deleteProductById(id);
        return Response.successResponse("Operation Successful", dataMsg);
    }


}
