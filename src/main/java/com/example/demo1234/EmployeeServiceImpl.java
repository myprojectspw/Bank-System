package com.example.demo1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        // Optional<Employee> result = employeeRepository.findAll(theId);
        //
        // Employee theEmployee = null;
        //
        // if (result.isPresent()) {
        // theEmployee = result.get();
        // } else {
        // // we didn't find the employee
        // throw new RuntimeException("Did not find employee id - " + theId);
        // }
        //
        return null;
    }

    @Override
    public void save(Employee theEmployee) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO emplo (id, first_name, last_name, email, money) VALUES ('"
                               + theEmployee.getId()
                               + "','"
                               + theEmployee.getFirstName()
                               + "','"
                               + theEmployee.getLastName()
                               + "','"
                               + theEmployee.getEmail()
                               + "','"
                               + 0
                               + "');");
        } catch (Exception e) {
            System.out.println(e.toString() + "EXCEPTION");
        }

    }

    @Override
    public void deleteById(int theId) {
        // employeeRepository.deleteById(theId);
        System.out.println(theId);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM emplo WHERE id=" + theId + ";");
        } catch (Exception e) {
            System.out.println(e.toString() + "EXCEPTION");
        }
    }

    @Override
    public void updateMoney(Employee theEmployee, double money) {
        System.out.println(theEmployee);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE emplo SET money=money+" + money + " WHERE id=" + theEmployee.getId() + ";");
        } catch (Exception e) {
            System.out.println(e.toString() + "EXCEPTION");
        }

    }

    @Override
    public void extractMoney(Employee theEmployee, double money) {
        System.out.println(theEmployee);
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE emplo SET money=money-" + money + " WHERE id=" + theEmployee.getId() + ";");
        } catch (Exception e) {
            System.out.println(e.toString() + "EXCEPTION");
        }

    }

}
