package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Name;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema ="information_schema", name = "employee")
public class Employee {

    //todo id нужно инкрементить через @SequenceGenerator(), смотри в fccr
    @Id
    private Long id;
    private String name;
    private int salary;


}
