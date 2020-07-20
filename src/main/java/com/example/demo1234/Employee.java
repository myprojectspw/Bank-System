package com.example.demo1234;

public class Employee {


    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private double money;

    // define constructors

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, String email, double money) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.money = money;
    }

    public Employee(String firstName, String lastName, String email, double money) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.money = money;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // define tostring

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ",money=" + money + "]";
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

}
