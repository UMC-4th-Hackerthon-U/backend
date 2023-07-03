package com.example.kicking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class KickingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KickingApplication.class, args);
    }

}
