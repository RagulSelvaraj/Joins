package com.example.joins.Service;

import com.example.joins.model.Customer;
import com.example.joins.model.Order;
import com.example.joins.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrders( Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }


    public BigDecimal getTotalRevenueForCustomer(Customer customer) {
        return orderRepository.getTotalRevenueForCustomer(customer);
    }

    public List<Object[]> countOrdersByCustomer() {
        return orderRepository.countOrdersByCustomer();
    }
}
