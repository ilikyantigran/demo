package com.example.demo.api;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeInterface {
//    Employee findById(int id);

    Employee updateSalary(int id, int salary);

    Employee save(Employee employee);

    void deleteById(String id);

    List<Employee> findAll();
}
