package generics;

import superclasses.employee.Employee;

public class Order<T> {

    private String name;
    private T item;
    private Employee employeeAsignedTo;

    public Order(String name, T item, Employee employeeAsignedTo) {
        this.name = name;
        this.item = item;
        this.employeeAsignedTo = employeeAsignedTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Employee getEmployeeAsignedTo() {
        return employeeAsignedTo;
    }

    public void setEmployeeAsignedTo(Employee employeeAsignedTo) {
        this.employeeAsignedTo = employeeAsignedTo;
    }
}