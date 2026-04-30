package superclasses.employee;

import company.Project;
import enums.Department;
import enums.EmployeeStatus;
import enums.Rating;
import exceptions.InvalidSalaryException;
import interfaces.Payable;
import interfaces.Workable;
import superclasses.Human;

import java.util.Objects;

public class Employee extends Human implements Payable, Workable {

    private String role;
    private EmployeeStatus status;
    private Rating rating;
    private Department department;

    public Employee(String name, int age, String role, Department department) {
        super(name, age);
        this.role = role;
        status = EmployeeStatus.IS_NOT_WORKING;
        rating = Rating.NULL;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(role, employee.role) && Objects.equals(status, employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, status);
    }

    @Override
    public void receiveSalary(double amount) {
        if (amount < 2000) {
            throw new InvalidSalaryException("Salary amount must be greater than 2000, not-" + amount);
        } else {
            System.out.println("Employee received a salary of " + amount);
        }
    }

    @Override
    public void startWork() {
        System.out.println("Employee is starting work");
    }

    @Override
    public void stopWork() {
        System.out.println("Employee is stopping working");
    }

    @Override
    public void submitTask(Project project) {
        System.out.println("Employee submitting project:" + project.getName());
    }

    @Override
    public void resume() {
        System.out.println("name is " + super.getName() + " age is-" + super.getAge() + "Role is " + this.role);
    }

    // getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
