package superClasses.employee;

import company.Project;
import interfaces.Payable;
import interfaces.Workable;
import superClasses.Human;

public class Employee extends Human implements Payable, Workable {

    private String role;
    private boolean isWorking;

    public Employee(String name, String role) {
        super(name);
        this.role = role;
        isWorking = false;
    }

    @Override
    public void receiveSalary(double amount) {
        System.out.println("Employee received a salary of " + amount);
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
        System.out.println("name is " + super.name + "Role is " + this.role);
    }

    // getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
