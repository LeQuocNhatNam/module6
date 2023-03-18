package com.example.busapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BusAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusAppApplication.class, args);
    }

}
