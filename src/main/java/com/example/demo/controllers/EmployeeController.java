package com.example.demo.controllers;

//todo Название пакета неверный формат. controller - то есть не множественное число.

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor()
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees(Model model) { //todo параметр не используется
        List<Employee> employees = employeeService.findAllEmployees(); //todo переменная не использутся
        return employeeService.findAllEmployees();
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо
    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо
    @PostMapping("/delete")//todo зачем POST ? есть отдельный HTTP метод для таких нужд. + Использовать тело для передачи id так себе). Используй @PathVariable
    public void deleteEmployee(@RequestBody String id) {
        employeeService.deleteEmployeeById(id);
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо
    @PostMapping("/update")//todo зачем POST ? есть отдельный HTTP метод для таких нужд.
    public void updateEmployeesSalary(@RequestBody Employee employee) {
        employeeService.saveChangedEmployee(employee);
    }
}
