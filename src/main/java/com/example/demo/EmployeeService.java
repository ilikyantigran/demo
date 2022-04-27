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

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee saveChangedEmloyee(Employee employee){
        return employeeRepository.save(employee);
    }
}
