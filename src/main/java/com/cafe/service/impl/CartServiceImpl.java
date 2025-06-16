package com.cafe.service.impl;

import com.cafe.entity.Cart;
import com.cafe.exception.CafeCustomException;
import com.cafe.repository.CartRepository;
import com.cafe.service.CartService;
import com.cafe.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    MenuService menuService;

    @Override
    public Cart addItemToCart(Long itemId, int quantity, Long tableId) throws CafeCustomException {
        Cart cart = Cart.builder()
                .tableId(tableId)
                .quantity(quantity)
                .itemId(itemId)
                .build();

        if(menuService.checkIfItemExists(itemId) != null){
            return cartRepository.save(cart);
        }
        else{
            throw new CafeCustomException(100, "Item doesnt exist");
        }
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
