package com.example.session12_it211_bai3;

import com.example.session12_it211_bai3.controller.OrderController;
import com.example.session12_it211_bai3.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired private MockMvc mockMvc;

    @MockitoBean
    private OrderService service;

    @Test
    void testGetOrders() throws Exception {
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetById_NotFound() throws Exception {
        when(service.getOrderById(99L)).thenThrow(new RuntimeException());
        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound());
    }
}