CREATE TABLE orders (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        customer_id BIGINT NOT NULL,
                        product VARCHAR(255) NOT NULL,
                        quantity INT NOT NULL,
                        price DECIMAL(10,2) NOT NULL,
                        FOREIGN KEY (customer_id) REFERENCES customers(id)
);
