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
@CrossOrigin(origins = "https://thawing-river-01959.herokuapp.com/")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @CrossOrigin
    @GetMapping("/emp")
    public List<Employee> listEmployeesAll() {
        return employeeRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/emp/{id}")
    public Employee getOneEmployee(@PathVariable String id) {
        int blogId = Integer.parseInt(id);
        return employeeRepository.findOne(blogId);
    }

    @CrossOrigin
    @PostMapping("/emp")
    public List<Employee> create(@RequestBody Map<String, String> body) {
        int id = Integer.valueOf(body.get("id"));
        String name = body.get("name");
        String surname = body.get("surname");
        String email = body.get("email");
        int money = 0;
        employeeRepository.save(new Employee(id, name, surname, email, money));
        return employeeRepository.findAll();
    }

    @CrossOrigin
    @PutMapping("/emp/{id}")
    public List<Employee> update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int blogId = Integer.parseInt(id);

        Employee emp = employeeRepository.findOne(blogId);
        if(Boolean.valueOf(body.get("deposit")))
        {
            emp.setMoney(emp.getMoney() + Integer.valueOf(body.get("money")));
        }
        else if(Boolean.valueOf(body.get("extract")))
        {
            emp.setMoney(emp.getMoney() - Integer.valueOf(body.get("money")));
        }
        else if(Boolean.valueOf(body.get("transfer")))
        {
            Employee from = employeeRepository.findOne(blogId);
            Employee to = employeeRepository.findOne(Integer.valueOf(body.get("to")));
            from.setMoney(from.getMoney() - Integer.valueOf(body.get("money")));
            to.setMoney(to.getMoney() + Integer.valueOf(body.get("money")));
            employeeRepository.save(from);
            employeeRepository.save(to);
        }
        else
        {
            emp.setName(body.get("name"));
            emp.setSurname(body.get("surname"));
            emp.setEmail(body.get("email"));
        }
        employeeRepository.save(emp);
        return employeeRepository.findAll();
    }

    @CrossOrigin
    @DeleteMapping("emp/{id}")
    public List<Employee> delete(@PathVariable String id) {
        int empId = Integer.parseInt(id);
        employeeRepository.delete(empId);
        return employeeRepository.findAll();
    }

}
