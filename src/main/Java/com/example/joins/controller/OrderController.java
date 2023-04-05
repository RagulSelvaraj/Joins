package com.example.joins.controller;
import com.example.joins.Service.OrderService;
import com.example.joins.model.Customer;
import com.example.joins.model.Order;
import com.example.joins.repository.CustomerRepository;
import com.example.joins.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("")
    public Order createOrder(Order order){
        return orderService.createOrders(order);
    }

    @PostMapping("/customers")
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

    @GetMapping("/revenue/{customerId}")
    public ResponseEntity<BigDecimal> getTotalRevenueForCustomer(@PathVariable Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        BigDecimal totalRevenue = orderService.getTotalRevenueForCustomer(customer);
        return ResponseEntity.ok(totalRevenue);
    }

    @GetMapping("/counts")
    public ResponseEntity<List<Object[]>> countOrdersByCustomer() {
        List<Object[]> counts = orderService.countOrdersByCustomer();
        return new ResponseEntity<>(counts, HttpStatus.OK);
    }

}