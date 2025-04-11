package com.cafe.service.impl;

import com.cafe.entity.OrderItem;
import com.cafe.repository.OrderItemRepository;
import com.cafe.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceItemImpl implements OrderItemService {

    OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findOrderItemByOrderId(orderId);
        if(orderItems == null || orderItems.isEmpty())
            return List.of();
        return orderItems;
    }

    @Override
    public OrderItem saveItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
