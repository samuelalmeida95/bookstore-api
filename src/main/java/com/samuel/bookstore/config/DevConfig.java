package com.samuel.bookstore.config;

import com.samuel.bookstore.services.DBservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    
    @Autowired
    private DBservice dbService;
}
