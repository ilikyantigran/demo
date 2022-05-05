package com.example.demo.controller;

import com.example.demo.api.EmployeeInterface;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor()
public class EmployeeController {

    private static final String SUCCESS_MESSAGE = "success"; //todo у констат другой стиль именования
                                                             // done
    private final EmployeeInterface employeeInterface;

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees() {
        return employeeInterface.findAll();
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        employeeInterface.save(employee);
        return SUCCESS_MESSAGE;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) throws IdNotFoundException {
        employeeInterface.deleteById(id);
        return SUCCESS_MESSAGE;
    }

    @PutMapping("/update")
    public String updateEmployeesSalary(@RequestBody Employee employee) throws Exception {
        employeeInterface.updateSalary(employee.getId(), employee.getSalary());
        return SUCCESS_MESSAGE;
    }
}
