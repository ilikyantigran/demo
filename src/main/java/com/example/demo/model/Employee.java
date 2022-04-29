package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(schema = "information_schema", name = "employee")
@SequenceGenerator(schema = "information_schema", name = "employee_s", sequenceName = "information_schema.employee_s", allocationSize = 1)
public class Employee {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_s")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;


}
