package com.cafe.service;

import com.cafe.entity.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> getOrder(Long tableId);

    Orders placeOrder(Long tableId);

    Orders updateOrderStatus(Long orderId, String status);
}
