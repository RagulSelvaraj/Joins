package com.example.joins;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:/db")
                .baselineOnMigrate(true)
                .load();
        flyway.migrate();
        return flyway;
    }
}

