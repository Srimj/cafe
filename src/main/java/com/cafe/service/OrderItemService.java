package com.cafe.service;

import com.cafe.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> findByOrderId(Long orderId);

    OrderItem saveItem(OrderItem orderItem);

}
