package com.example.demo.controller;

//todo Название пакета неверный формат. controller - то есть не множественное число.// done

import com.example.demo.api.EmployeeInterface;
import com.example.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor()
public class EmployeeController {

    private static final String successMessage = "success";
    private final EmployeeInterface employeeInterface;

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees() { //todo параметр не используется// done
         //todo переменная не использутся// done
        return employeeInterface.findAll();
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо
    // done
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        employeeInterface.save(employee);
        return successMessage;
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо // done
    @DeleteMapping("/delete/{id}")//todo зачем POST ? есть отдельный HTTP метод для таких нужд. + Использовать тело для передачи id так себе). Используй @PathVariable // done
    public String deleteEmployee(@PathVariable String id) {
        employeeInterface.deleteById(id);
        return successMessage;
    }

    //todo почему void, вернуть хотя "success" или "done", как сообщение пользователю ,что все прошло хорошо //done
    @PutMapping("/update")//todo зачем POST ? есть отдельный HTTP метод для таких нужд. //done
    public String updateEmployeesSalary(@RequestBody Employee employee) {
        employeeInterface.updateSalary(employee.getId(), employee.getSalary());
        return successMessage;
    }
}
