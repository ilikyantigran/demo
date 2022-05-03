package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {
    //todo общие замечание))
    // желательно, называть проект и его пакеты в зависимости от его назначения
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
