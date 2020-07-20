package com.example.demo1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/emp")
    public List<Employee> listEmployeesAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/emp/{id}")
    public Employee getOneEmployee(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return employeeRepository.findOne(blogId);
    }

    @PostMapping("/emp")
    public List<Employee> create(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String surname = body.get("surname");
        String email = body.get("email");
        int money = 0;
        employeeRepository.save(new Employee(name, surname, email, money));
        return employeeRepository.findAll();
    }

    @PutMapping("/emp/{id}")
    public Employee update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);
        // getting blog
        Employee emp = employeeRepository.findOne(blogId);
        emp.setName(body.get("name"));
        emp.setSurname(body.get("surname"));
        return employeeRepository.save(emp);
    }

    @DeleteMapping("emp/{id}")
    public boolean delete(@PathVariable String id) {
        int empId = Integer.parseInt(id);
        employeeRepository.delete(empId);
        return true;
    }

}
