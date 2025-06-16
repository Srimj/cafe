package com.cafe.service;

import com.cafe.entity.Cart;
import com.cafe.exception.CafeCustomException;

import java.util.List;

public interface CartService {
    Cart addItemToCart(Long itemId, int quants,  Long tableId) throws CafeCustomException;

    List<Cart> getCart(Long tableId);

    void clearCart(Long tableId);
}
