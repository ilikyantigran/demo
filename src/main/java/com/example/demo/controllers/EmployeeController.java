package com.example.demo.controllers;


import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor()
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        return employeeService.findAllEmployees();
    }


    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @PostMapping("/delete")
    public void deleteEmployee(@RequestBody String id) {
        employeeService.deleteEmployeeById(id);
    }


    @PostMapping("/update")
    public void updateEmployeesSalary(@RequestBody Employee employee) {
        employeeService.saveChangedEmployee(employee);
    }
}
