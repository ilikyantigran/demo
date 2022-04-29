package com.example.demo.services;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Клиент с id = " + id + " не найден"));
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(parseInt(id));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee saveChangedEmployee(Employee employee) {
        Employee changedEmployee = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Клиент с id = " + employee.getId() + " не найден"));
        changedEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(changedEmployee);
    }
}
