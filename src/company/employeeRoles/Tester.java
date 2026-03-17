package company.employeeRoles;

import superClasses.Employee;

public class Tester extends Employee {

    private String status; // is_working, Is_In_queue

    public Tester(String name) {
        super(name, "Tester");
        status = "Is_In_queue";
    }

    @Override
    public void resume() {
        System.out.println("resumeTester: name-" + super.name + " role-" + super.getRole() + " status-" + this.status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
