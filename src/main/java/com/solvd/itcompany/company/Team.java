package com.solvd.itcompany.company;

import com.solvd.itcompany.superclasses.employee.Employee;

import java.util.HashSet;
import java.util.Set;

public class Team {

    private String name;
    private Set<Employee> employees;
    private Customer customer;

    public Team(String name) {
        this.name = name;
        employees = new HashSet<>();
    }

    // functions
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
