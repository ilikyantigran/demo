package com.example.demo.services;
//todo Название пакета неверный формат. service - то есть не множественное число.
// к слову, если следовать логике названий получается, что будет неправильно называвть model и repository
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

//todo обращения к сервисам лучше производить через интерфейсы
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //todo общие замечание
    //  русские слова в коде плохая практика
    // необходимо использовать ResourceBundle. Можно посмотреть, как сделать в fccr, сервис называется MessageService

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть))
    public Employee findEmployeeById(int id) { //todo не используется
        //todo почему RuntimeException ? Не лучше ли использовать Checked Exception ?
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Клиент с id = " + id + " не найден"));
    }

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть))
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть))
    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(parseInt(id));
    }

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть))
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    //todo название ни оч, лучше update. ++ Тут в методе происходит, что то странное. Название метода говорит,
    // что сохраняет измененного работника, а на деле только изменение его зп
    public Employee saveChangedEmployee(Employee employee) {
        //todo почему RuntimeException ? Не лучше ли использовать Checked Exception ? + переноси строки
        // в скобках findById происходит проверка, такие вещи нужно выносить отдельно, так как не очевидно с первого раза, что происходит
        // название переменной не оч)
        Employee changedEmployee = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Клиент с id = " + employee.getId() + " не найден"));
        changedEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(changedEmployee);
    }
}
