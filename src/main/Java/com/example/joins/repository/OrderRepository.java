package com.example.joins.repository;

import com.example.joins.model.Customer;
import com.example.joins.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.customer WHERE o.customer.id = :customerId")
    List<Order> findByCustomerId(@Param("customerId") Long customerId);


    @Query("SELECT SUM(o.price * o.quantity) FROM Order o WHERE o.customer = :customer")
    BigDecimal getTotalRevenueForCustomer(@Param("customer") Customer customer);

    @Query("SELECT o.customer.id,o.customer.name, COUNT(o) FROM Order o GROUP BY o.customer.id")
    List<Object[]> countOrdersByCustomer();

}
