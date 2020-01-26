package com.example.demo1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public List<Employee> emp;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    public List<Employee> getFromDataBase() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/emp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            // here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emplo");
            emp = new ArrayList<>();
            while (rs.next()) {
                // System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                emp.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
            }
            // con.close();
        } catch (Exception e) {
            System.out.println("EXCEPTION");
            System.out.println(e.toString());
        }
        return emp;
    }

    public void insertData() {

    }

    // @GetMapping("/list")
    // public String listEmployees(Model theModel) throws SQLException {
    // List<Employee> theEmployees = getFromDataBase();
    // theModel.addAttribute("employees", theEmployees);
    // return "employees/list-employees";
    // }

    @GetMapping("/list")
    public String listEmployeesAll(Model theModel) {
        List<Employee> theEmployees = getFromDataBase();
        for (Employee e : theEmployees) {
            System.out.println(e.getEmail()
                                .toString());
        }
        theModel.addAttribute("employees", theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        Employee theEmployee = null;
        for (Employee e : emp) {
            if (e.getId() == theId) {
                theEmployee = e;
            }
        }

        // get the employee from the service
        // Employee theEmployee = employeeService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/showFormForDeposit")
    public String showFormForDeposit(Model theModel) {

        // create new employee
        Employee theEmployee = new Employee();

        // add attribute for employee
        theModel.addAttribute("employee", theEmployee);

        // return form for deposit
        return "employees/employee-deposit-form";
    }

    @GetMapping("/showFormForExtract")
    public String showFormForExtract(Model theModel) {

        // create new employee
        Employee theEmployee = new Employee();

        // add attribute for employee
        theModel.addAttribute("employee", theEmployee);

        // return form for extract
        return "employees/employee-extract-form";
    }

    @GetMapping("/showFormForTransfer")
    public String showFormForTransfer(Model theModel) {

        // create new transfer object
        Transfer transfer = new Transfer();

        // add attribute for transfer
        theModel.addAttribute("transfer", transfer);

        // return form for extract
        return "employees/employee-transfer-form";
    }

    @PostMapping("/depositMoney")
    public String depositMoneyEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.updateMoney(theEmployee, theEmployee.getMoney());

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/extractMoney")
    public String extractMoneyEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.extractMoney(theEmployee, theEmployee.getMoney());

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/transferMoney")
    public String transferMoneyEmployee(@ModelAttribute("employeeOne") Transfer id) {

        // Extract Money from first account
        Employee theEmployeeExtract = employeeService.findById(id.getId1());
        theEmployeeExtract.setMoney(theEmployeeExtract.getMoney() - id.getMoney());
        employeeService.save(theEmployeeExtract);

        // Deposit Money form second account
        Employee theEmployeeDeposit = employeeService.findById(id.getId2());
        theEmployeeDeposit.setMoney(theEmployeeDeposit.getMoney() + id.getMoney());
        employeeService.save(theEmployeeDeposit);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showEmployeesFirstName")
    public String showEmployeesFirstName(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();
        theEmployees.sort((h1, h2) -> h1.getFirstName()
                                        .compareTo(h2.getFirstName()));

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);
        System.out.println(theEmployees.toString());
        return "employees/list-employees";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        // save the employee
        int i = 0;
        if (emp != null) {
            for (Employee e : emp) {
                if (e.getId() == i) {
                    i++;
                } else {
                    break;
                }
            }
        }
        theEmployee.setId(i);
        theEmployee.setMoney(0);
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId) {

        // delete the employee
        employeeService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/employees/list";

    }
}
