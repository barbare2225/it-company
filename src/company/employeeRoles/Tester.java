package company.employeeRoles;

import superclasses.employee.Employee;

import java.util.Objects;

public class Tester extends Employee {

    private String status; // is_working, Is_In_queue

    public Tester(String name, int age) {
        super(name, age, "Tester");
        status = "Is_In_queue";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tester tester)) return false;
        return super.equals(o) && Objects.equals(status, tester.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status);
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
