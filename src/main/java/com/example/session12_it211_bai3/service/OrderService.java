package com.example.session12_it211_bai3.service;

import com.example.session12_it211_bai3.model.entity.Order;
import com.example.session12_it211_bai3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(1);

    public List<Order> getAllOrders() { return orders; }

    public Order getOrderById(Long id) {
        return orders.stream().filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order addOrder(Order order) {
        order.setId(counter.getAndIncrement());
        orders.add(order);
        return order;
    }
}