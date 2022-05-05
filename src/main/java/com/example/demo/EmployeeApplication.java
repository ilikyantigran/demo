package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication {
    //todo общие замечание))
    // желательно, называть проект и его пакеты в зависимости от его назначения
    // Не уверен, стоит ли мне перелопачивать com.example.demo во что-то другое тут, но, в будущих проектах юзать что-то типа ru.digitalleague.education?
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
