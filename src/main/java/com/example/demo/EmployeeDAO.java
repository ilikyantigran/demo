package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int PEOPLE_COUNT;

    @Value("${db.login}")
    private static String PASSWORD;
    @Value("${db.password}")
    private static String USERNAME;
    @Value("${db.URL}")
    private static String URL;

    private List<Employee> employees;

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> index() {

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Employee person = new Employee();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setSalary(resultSet.getInt("salary"));

                employees.add(person);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employees;
    }

    public void save(Employee emp) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + ++PEOPLE_COUNT + ",'" + emp.getName() +
                    "'," + emp.getSalary() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateSalary(int id, Employee updatedEmp) {
        Employee empToBeUpdated = show(id);
        empToBeUpdated.setSalary(updatedEmp.getSalary());
    }

    public Employee show(int id) {
        return employees.stream().filter(emp -> emp.getId() == id).findAny().orElse(null);
    }

}
