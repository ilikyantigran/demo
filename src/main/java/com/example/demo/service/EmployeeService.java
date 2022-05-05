package com.example.demo.service;
//todo Название пакета неверный формат. service - то есть не множественное число.
// к слову, если следовать логике названий получается, что будет неправильно называвть model и repository ..//done

import com.example.demo.api.EmployeeInterface;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

import static java.lang.Integer.parseInt;

//todo обращения к сервисам лучше производить через интерфейсы // done
@Service
public class EmployeeService implements EmployeeInterface {
    private final EmployeeRepository employeeRepository;
    private final MessageService messageService;


    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, MessageService messageService) {
        this.employeeRepository = employeeRepository;
        this.messageService = messageService;
    }

    //todo общие замечание
    //  русские слова в коде плохая практика
    // необходимо использовать ResourceBundle. Можно посмотреть, как сделать в fccr, сервис называется MessageService // done

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть)) // done
    @Override
    public Employee findById(int id) { //todo не используется
        //todo почему RuntimeException ? Не лучше ли использовать Checked Exception ? // done
        return employeeRepository.findById(id).orElseThrow(getNotFoundIdExeption(id));
    }


    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть)) // done
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть)) // done
    @Override
    public void deleteById(String id) {
        employeeRepository.findById(parseInt(id))
                .orElseThrow(getNotFoundIdExeption(parseInt(id)));
        employeeRepository.deleteById(parseInt(id));
    }

    //todo зачем приписывать к каждому методу Employee, если в названии сервиса есть)) // done
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    //todo название ни оч, лучше update. ++ Тут в методе происходит, что то странное. Название метода говорит,
    // что сохраняет измененного работника, а на деле только изменение его зп // done
    @Override
    public Employee updateSalary(int id, int salary) {
        //todo почему RuntimeException ? Не лучше ли использовать Checked Exception ? + переноси строки // done
        // в скобках findById происходит проверка, такие вещи нужно выносить отдельно, так как не очевидно с первого раза, что происходит // done
        // название переменной не оч) // done
        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(getNotFoundIdExeption(id));
        updatedEmployee.setSalary(salary);
        return employeeRepository.save(updatedEmployee);
    }

    private Supplier<IllegalArgumentException> getNotFoundIdExeption(int id) {
        return () -> new IllegalArgumentException(messageService.getMessage("id.not.found.exceprion", id));
    }
}
