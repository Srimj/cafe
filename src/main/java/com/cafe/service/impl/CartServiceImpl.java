package com.cafe.service.impl;

import com.cafe.entity.Cart;
import com.cafe.repository.CartRepository;
import com.cafe.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;

    @Override
    public Cart addItemToCart(Long itemId, int quantity, Long tableId) {
        Cart cart = Cart.builder()
                .tableId(tableId)
                .quantity(quantity)
                .itemId(itemId)
                .build();
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCart(Long tableId) {
        List<Cart> cart = cartRepository.findByTableId(tableId);
        if(cart == null || cart.isEmpty())
                return List.of();
        return cart;
    }

    @Override
    public void clearCart(Long tableId){
        List<Cart> cart = cartRepository.findByTableId(tableId);
        if(cart != null && !cart.isEmpty()){
            cartRepository.deleteAll(cart);
        }
    }
}
