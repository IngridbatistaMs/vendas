package com.vendas.controller;

import com.vendas.model.Cart;
import com.vendas.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService service;

    @PostMapping
    public ResponseEntity<Cart> register(){
        return ResponseEntity.ok(service.save());
    }

    @PutMapping("/make/{id}")
    public ResponseEntity<Cart> makePurchase(@PathVariable Long id){
        return ResponseEntity.ok(service.makePurchase(id));
    }

    @PutMapping("/addToCart/{cartId}/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId){
        var cart = service.addProductToCart(cartId, productId);
        return ResponseEntity.ok(cart);
    }

    @GetMapping
    public ResponseEntity<Iterable<Cart>> getAllCarts(){
        return ResponseEntity.ok(service.findAllClosed(false));
    }

    @GetMapping("/history")
    public ResponseEntity<Iterable<Cart>> getHistory(){
        return ResponseEntity.ok(service.findAllClosed(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }
}
