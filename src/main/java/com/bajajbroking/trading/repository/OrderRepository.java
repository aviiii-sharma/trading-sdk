package com.bajajbroking.trading.repository;

import com.bajajbroking.trading.model.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {

    private final Map<String, Order> orderStore = new HashMap<>();

    public Order save(Order order) {
        orderStore.put(order.getOrderId(), order);
        return order;
    }

    public Order findById(String orderId) {
        return orderStore.get(orderId);
    }

    public Collection<Order> findAll() {
        return orderStore.values();
    }
}
