package company.employeeRoles;

import superClasses.employee.Employee;

public class Tester extends Employee {

    private String status; // is_working, Is_In_queue

    public Tester(String name, int age) {
        super(name, age, "Tester");
        status = "Is_In_queue";
    }

    @Override
    public void resume() {
        System.out.println("resumeTester: name-" + super.getName() + " age-" + super.getAge() + " role-" + super.getRole() + " status-" + this.status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
