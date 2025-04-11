package com.cafe.service.impl;

import com.cafe.entity.Cart;
import com.cafe.entity.Menu;
import com.cafe.entity.OrderItem;
import com.cafe.entity.Orders;
import com.cafe.repository.OrderRepository;
import com.cafe.service.CartService;
import com.cafe.service.MenuService;
import com.cafe.service.OrderItemService;
import com.cafe.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    CartService cartService;
    MenuService menuService;
    OrderItemService orderItemService;

    @Override
    public List<Orders> getOrder(Long tableId) {
        List<Orders> orders = orderRepository.findOrderByTableId(tableId);
        if(orders == null || orders.isEmpty())
                return List.of();
        return orders;
    }

    @Override
    public Orders placeOrder(Long tableId) {
        List<Cart> cart = cartService.getCart(tableId);
        if(cart.isEmpty())
            throw new RuntimeException("Order cannot be placed with empty cart");

        Orders order = Orders.builder()
                .tableId(tableId)
                .createDt(LocalDateTime.now())
                .status("PENDING")
                .build();

        order = orderRepository.save(order);
        for(Cart item : cart) {
            Menu menuItem = menuService.getMenuById(item.getItemId());

            OrderItem orderItem = OrderItem.builder()
                    .itemId(item.getItemId())
                    .quantity(item.getQuantity())
                    .price(menuItem.getPrice())
                    .itemName(menuItem.getName())
                    .orderId(order.getId())
                    .build();

                    orderItemService.saveItem(orderItem);

        }
        order = updateOrderStatus(order.getId(), "PLACED");
        cartService.clearCart(tableId);
        return order;
    }

    @Override
    public Orders updateOrderStatus(Long orderId, String status) {
        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
