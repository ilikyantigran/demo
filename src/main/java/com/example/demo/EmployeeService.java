package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //todo findById возвращает Optional, его нужно обрабатывать через orElseThrow потому что если ничего не найдется, нужно сигнализировать пользователю
    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    //todo опечатка
    public Employee saveChangedEmloyee(Employee employee){
        return employeeRepository.save(employee);
    }
}
