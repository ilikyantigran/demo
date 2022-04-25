package com.example.demo;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final EmployeeDAO emplDAO;

    public Controller(EmployeeDAO emplDAO) {
        this.emplDAO = emplDAO;
    }
}
