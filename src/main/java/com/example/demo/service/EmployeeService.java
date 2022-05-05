package com.example.demo.service;

import com.example.demo.api.EmployeeInterface;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;


@Service
public class EmployeeService implements EmployeeInterface { //todo какой то метод не имплементировал
                                                            // done вроде. Был метод, который я закомментил и не использовал. Сейчас вроде юзаю 4 из 4, которые
                                                            // были в EmployeeInterface
    private final EmployeeRepository employeeRepository;
    private final MessageService messageService;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, MessageService messageService) {
        this.employeeRepository = employeeRepository;
        this.messageService = messageService;
    }

    //todo не оставляй закоменченный код)
    // done


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(String id) throws IdNotFoundException {
        employeeRepository.findById(parseInt(id))
                .orElseThrow(getNotFoundIdException(parseInt(id)));
        employeeRepository.deleteById(parseInt(id));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public Employee updateSalary(int id, int salary) throws IdNotFoundException {
        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(getNotFoundIdException(id));
        updatedEmployee.setSalary(salary);
        return employeeRepository.save(updatedEmployee);
    }

    private Supplier<IdNotFoundException> getNotFoundIdException(int id) {
        //todo IllegalArgumentException - тоже Runtime. Создай свое исключение от Exception
        // done
        return () -> new IdNotFoundException(messageService.getMessage("id.not.found.exception", id));
    }
}
