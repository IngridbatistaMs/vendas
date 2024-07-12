package com.vendas.service;

import com.vendas.model.Cart;

public interface CartService {

    Cart save();

    Cart makePurchase(Long id);

    Cart addProductToCart(Long cartId, Long productId);

    Iterable findAllClosed(boolean closed);

    Cart findById(Long id);
}
