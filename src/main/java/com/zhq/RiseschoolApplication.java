package com.zhq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class RiseschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiseschoolApplication.class, args);
    }

}
