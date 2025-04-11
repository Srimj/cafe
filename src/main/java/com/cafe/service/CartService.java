package com.cafe.service;

import com.cafe.entity.Cart;

import java.util.List;

public interface CartService {
    Cart addItemToCart(Long itemId, int quants,  Long tableId);

    List<Cart> getCart(Long tableId);

    void clearCart(Long tableId);
}
