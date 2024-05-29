package com.freshGoodies.userstories.cart.service.Impl;

import com.freshGoodies.userstories.cart.model.Cart;
import com.freshGoodies.userstories.cart.service.CartService;
import com.freshGoodies.userstories.exceptions.ProductNotFoundException;
import com.freshGoodies.userstories.product.model.Product;
import com.freshGoodies.userstories.product.service.ProductService;
import com.freshGoodies.userstories.product.service.ProductServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CartServiceImpl implements CartService {
    private final ProductService productService;

    public CartServiceImpl (ProductService productService){
        this.productService = productService;
    }
    List<Cart> carts = new ArrayList<>();
    AtomicLong counter = new AtomicLong();

    @Override
    public Cart addCart(Cart cart){
        List<Product> products = productService.getProductList();
        boolean cartExist = carts.stream().anyMatch(c -> c.getProductId() == cart.getProductId());
        boolean productExist = products.stream().anyMatch(p -> p.getId() == cart.getProductId());

        if (cartExist){
            throw new ProductNotFoundException("Cart is already present");
        } else if (!productExist) {
            throw new ProductNotFoundException("Product is not available");
        }
        cart.setId(counter.incrementAndGet());
        carts.add(cart);
        return cart;
    }

    @Override
    public List<Cart> getCartDetail(){
        List<Cart> cartWithDetailsProduct = new ArrayList<>();
        for (Cart cart : carts){
            long productId = cart.getProductId();
            Optional<Product> product = productService.getProductById(productId);
            cart.setProduct(product);
            cartWithDetailsProduct.add(cart);
        }
        return cartWithDetailsProduct;
    }

    @Override
    public Cart updateCart(long id, Cart newCart){
        Cart currentCart = carts.stream()
                .filter(cart -> cart.getId() == id)
                .findFirst()
                .orElse(null);

        if (currentCart == null){
            throw new ProductNotFoundException("Cart is not available");
        }

        currentCart.setQuantity(newCart.getQuantity());
        return currentCart;
    }

    @Override
    public Cart deleteCart(long id){
        Cart cart = carts.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (cart == null){
            throw new ProductNotFoundException("Tak ade yg bise didelete");
        }

        carts.removeIf(c -> c.getId() == id);
        return cart;
    }

}
