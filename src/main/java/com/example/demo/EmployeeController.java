package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        System.out.println(employees);
        model.addAttribute("employees", employees);
        return employeeService.findAllEmployees();
    }


    @PostMapping("/employee-create")
    public List<Employee> createEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        employeeService.saveChangedEmloyee(employee);
        return employeeService.findAllEmployees();
    }

    @PostMapping("/employee-delete")
    public List<Employee> deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployeeById(employee.getId());
        return employeeService.findAllEmployees();
    }


    @PostMapping("/employee-update")
    public List<Employee> updateEmployeesSalary(@RequestBody Employee employee) {
        Employee changedEmployee = employeeService.findEmployeeById(employee.getId());
        changedEmployee.setSalary(employee.getSalary());
        employeeService.saveChangedEmloyee(changedEmployee);
        return employeeService.findAllEmployees();
    }
}
