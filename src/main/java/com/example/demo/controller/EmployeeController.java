package com.example.demo.controller;

import com.example.demo.api.EmployeeInterface;
import com.example.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor()
public class EmployeeController {

    private static final String successMessage = "success"; //todo у констат другой стиль именования
    private final EmployeeInterface employeeInterface;

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees() {
        return employeeInterface.findAll();
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        employeeInterface.save(employee);
        return successMessage;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeInterface.deleteById(id);
        return successMessage;
    }

    @PutMapping("/update")
    public String updateEmployeesSalary(@RequestBody Employee employee) {
        employeeInterface.updateSalary(employee.getId(), employee.getSalary());
        return successMessage;
    }
}
