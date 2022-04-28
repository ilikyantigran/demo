package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

@RestController
//todo у тебя во всех рестах employee, так не делаю, обычно общий рест выносят в @RequestMapping(/employees), а в рестах избавляются от /save, /finAll, /delete
//@RequestMapping
//@RequiredArgsConstructor

//todo у тебя все классы лежат в одном пакете, их нужно распределить по разным паметам. Смотри как сделано в fccr
public class EmployeeController {

    private final EmployeeService employeeService;

    //todo так делать можно, но обычно это не пишут и делают @RequiredArgsConstructor
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(Model model) {
        List<Employee> employees = employeeService.findAllEmployees();
        //todo это ебанина, если ты хочешь что-то залогировать, нуэно писать логи
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

    //todo а зачем ты передаешь объект на удаление? Почему нельзя передать id?
    //
    @PostMapping("/employee-delete")
    public List<Employee> deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployeeById(employee.getId());
        //todo а зачем тебе что-то возвращать? Задача удалить?
        return employeeService.findAllEmployees();
    }


    @PostMapping("/employee-update")
    //todo логику не пишут в контроллерах, это делают в сервисах
    public List<Employee> updateEmployeesSalary(@RequestBody Employee employee) {
        Employee changedEmployee = employeeService.findEmployeeById(employee.getId());
        changedEmployee.setSalary(employee.getSalary());
        employeeService.saveChangedEmloyee(changedEmployee);
        //todo зачем тебе тут findAll? Если ты хочешь проверить правильность, нужно писать тесты. Не увидел ни одного
        return employeeService.findAllEmployees();
    }
}
