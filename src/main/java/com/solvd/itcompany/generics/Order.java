package com.solvd.itcompany.generics;

import com.solvd.itcompany.superclasses.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Order<T> {

    private String name;
    private List<T> item;
    private Employee employeeAsignedTo;

    public Order(String name) {
        item = new ArrayList<>();
        this.name = name;
    }

    public void addItem(T item) {
        this.item.add(item);
    }

    public void addEmployeeAsignedTo(Employee employee) {
        this.employeeAsignedTo = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getItem() {
        return item;
    }

    public void setItem(List<T> item) {
        this.item = item;
    }

    public Employee getEmployeeAsignedTo() {
        return employeeAsignedTo;
    }

    public void setEmployeeAsignedTo(Employee employeeAsignedTo) {
        this.employeeAsignedTo = employeeAsignedTo;
    }
}