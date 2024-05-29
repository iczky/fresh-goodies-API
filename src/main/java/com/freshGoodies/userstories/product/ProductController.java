package com.freshGoodies.userstories.product;

import com.freshGoodies.userstories.product.model.Product;
import com.freshGoodies.userstories.product.service.ProductService;
import com.freshGoodies.userstories.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Response<List<Product>>> getAllProduct(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category
    )
    {
        List<Product> productList;
        if (name == null && category == null){
            productList = productService.getAllProduct();
            return Response.successResponse(HttpStatus.OK.value(), "Get All Products", productList);
        } else {
            productList = productService.searchProduct(name, category);
            return Response.successResponse(HttpStatus.OK.value(), "Get " + name + "!!", productList);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Optional<Product>>> getProductById (@PathVariable long id){
        Optional<Product> product = productService.getProductById(id);
        return Response.successResponse("Get product detail", product);
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
