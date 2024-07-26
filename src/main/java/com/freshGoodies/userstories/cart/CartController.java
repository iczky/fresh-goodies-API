package com.freshGoodies.userstories.cart;

import com.freshGoodies.userstories.cart.dto.CartItemDto;
import com.freshGoodies.userstories.cart.entity.CartItem;
import com.freshGoodies.userstories.cart.service.CartService;
import com.freshGoodies.userstories.responses.Response;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody CartItem cartItem) {
        return Response.successResponse("Add cart successfully", cartService.addCart(cartItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeItem(@PathVariable Long id) {
        return Response.successResponse("Cart successfully deleted", cartService.deleteCart(id));
    }

}
