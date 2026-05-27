package com.example.session12_it211_bai3.repository;

import com.example.session12_it211_bai3.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Order save(Order order) {
        String sql = "INSERT INTO orders (customer_name, product, quantity, total) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getCustomerName(), order.getProduct(), order.getQuantity(), order.getTotalAmount());
        return order;
    }
}