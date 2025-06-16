package com.cafe.controller;

import com.cafe.entity.Cart;
import com.cafe.service.CartService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    CartService cartService;

    @PostMapping
    public Cart addToCart(@RequestBody @NonNull Map<String, String> cartMap, @RequestParam("tableId") long tableId) {
        Long itemId = !StringUtils.isBlank(cartMap.get("itemId")) ? Long.parseLong(cartMap.get("itemId")) : 0;
        int quantity = !StringUtils.isBlank(cartMap.get("quantity")) ? Integer.parseInt(cartMap.get("quantity")) : 0;
        return cartService.addItemToCart(itemId, quantity, tableId);
    }

    @GetMapping
    public List<Cart> getCart(@RequestParam("tableId") Long tableId) {
        return cartService.getCart(tableId);
    }
}
