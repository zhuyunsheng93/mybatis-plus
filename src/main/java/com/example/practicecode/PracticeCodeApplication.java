package com.example.practicecode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.practicecode.mapper")
public class PracticeCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeCodeApplication.class, args);
    }

}
