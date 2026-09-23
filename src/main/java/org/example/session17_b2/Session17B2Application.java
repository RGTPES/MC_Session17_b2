package org.example.session17_b2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Session17B2Application {

    public static void main(String[] args) {
        SpringApplication.run(Session17B2Application.class, args);
    }

}
