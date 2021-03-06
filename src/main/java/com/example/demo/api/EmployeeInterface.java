package com.example.demo.api;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeInterface { //todo плохое название. Лучше EmployeeService, а имплементацию EmployeeServiceImpl или DefaultEmployeeService

    Employee updateSalary(int id, int salary) throws IdNotFoundException;

    Employee save(Employee employee);

    void deleteById(String id) throws IdNotFoundException;

    List<Employee> findAll();
}
