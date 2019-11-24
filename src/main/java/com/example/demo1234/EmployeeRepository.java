package com.example.demo1234;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

    List<Employee> findAllByOrderByFirstNameAsc();

}
