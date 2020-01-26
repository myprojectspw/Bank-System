package com.example.demo1234;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void updateMoney(Employee theEmployee, double money);

    void extractMoney(Employee theEmployee, double money);

    void deleteById(int theId);

}
