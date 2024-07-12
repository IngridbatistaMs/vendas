package com.vendas.service.impl;

import com.vendas.model.Cart;
import com.vendas.model.CartRepository;
import com.vendas.model.Product;
import com.vendas.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    @Override
    public Cart save() {
        var cart = new Cart();
        return repository.save(cart);
    }

    @Override
    public Cart makePurchase(Long id) {
        var cart = repository.findById(id).orElse(null);

        if(cart == null){
            return null;
        }

        cart.setClosed(true);

        cart = repository.save(cart);

        return cart;
    }

    @Override
    public Cart addProductToCart(Long cartId, Long productId) {
        var productToAdd = new Product(productId);

        var cart = repository.findById(cartId).orElse(null);

        cart.getProducts().add(productToAdd);

        cart = repository.save(cart);

        cart.calculateTotalValue();

        return cart;
    }

    @Override
    public Iterable findAllClosed(boolean closed) {
        var carts = repository.findAllByClosed(closed);

        carts.forEach(cart -> cart.calculateTotalValue());

        return carts;
    }

    @Override
    public Cart findById(Long id) {
        var cart = repository.findById(id).orElse(null);

        if(cart == null){
            return null;
        }

        cart.calculateTotalValue();

        return cart;
    }
}
