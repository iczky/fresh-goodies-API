package com.freshGoodies.userstories.cart;

import com.freshGoodies.userstories.cart.entity.Cart;
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
    public ResponseEntity<Response<Cart>> addCart(@Valid @RequestBody Cart cart){
        Cart savedCart = cartService.addCart(cart);
        return Response.successResponse(HttpStatus.OK.value(), "Cart successfully add", cart);
    }

    @GetMapping
    public ResponseEntity<Response<List<CartWithDetail>>> getCartDetails(){
        return Response.successResponse(HttpStatus.OK.value(), "Details successfully shown", cartService.getCartDetail());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Cart>> updateCartQuantity(@PathVariable long id, @RequestBody Cart newCart){
        Cart updateCart = cartService.updateCart(id, newCart);
        return Response.successResponse(HttpStatus.OK.value(), "Quantity is updated", updateCart);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Cart>> deleteCart(@PathVariable long id){
        return Response.successResponse(HttpStatus.OK.value(), "Delete is successfully", cartService.deleteCart(id));
    }

}
