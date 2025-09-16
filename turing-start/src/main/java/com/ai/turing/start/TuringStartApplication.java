package com.ai.turing.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ai.turing")
public class TuringStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(TuringStartApplication.class, args);
    }

}
