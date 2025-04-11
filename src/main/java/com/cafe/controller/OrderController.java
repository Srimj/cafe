package com.cafe.controller;

import com.cafe.entity.Orders;
import com.cafe.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService;

    @GetMapping
    public List<Orders> getOrder(@RequestParam("tableId") Long tableId) {
        return orderService.getOrder(tableId);
    }

    @PostMapping
    public Orders placeOrder(@RequestParam("tableId") Long tableId){
        return orderService.placeOrder(tableId);
    }
}
