CREATE TABLE customer_order (
                                customer_id BIGINT NOT NULL,
                                order_id BIGINT NOT NULL,
                                PRIMARY KEY (customer_id, order_id),
                                FOREIGN KEY (customer_id) REFERENCES customers(id),
                                FOREIGN KEY (order_id) REFERENCES orders(id)
) ;