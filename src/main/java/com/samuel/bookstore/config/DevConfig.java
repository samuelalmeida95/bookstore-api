package com.samuel.bookstore.config;

import com.samuel.bookstore.services.DBservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBservice dbService;

    @Value("$(spring.jpa.hibernate.ddl-auto)")
    private String strategy;

    @Bean
    public boolean instanciaBaseDeDados() {
        if (strategy.equals("create")) {
            this.dbService.instanciaBaseDeDados();
        }
        return false;
    }
}
