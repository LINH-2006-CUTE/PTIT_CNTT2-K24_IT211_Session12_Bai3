package com.example.session12_it211_bai3;


import com.example.session12_it211_bai3.model.entity.Order;
import com.example.session12_it211_bai3.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks private OrderService service;

    @Test
    void getOrderById_NotFound_ThrowException() {
        assertThrows(RuntimeException.class, () -> service.getOrderById(99L));
    }

    @Test
    void addOrder_Success() {
        Order o = new Order(null, "Linh", "Book", 1, 10.0);
        Order saved = service.addOrder(o);
        assertNotNull(saved.getId());
    }
}