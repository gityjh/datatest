package com.example.datatest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.example.datatest.haoyue.mapper")
@SpringBootApplication
public class DatatestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatatestApplication.class, args);
    }

}
