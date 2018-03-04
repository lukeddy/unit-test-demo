package com.example.ut.demo;

import java.util.concurrent.ForkJoinPool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UnitTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitTestDemoApplication.class, args);
    }

    @Bean
    public ForkJoinPool assembleWorkers(@Value("${app.rpc.threadpool.coreSize}") int coreSize) {
        return new ForkJoinPool(coreSize);
    }
}
