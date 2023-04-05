package com.example.joins.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String product;

    private Integer quantity;

    private BigDecimal price;

}
