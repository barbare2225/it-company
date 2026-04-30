package company.employeeRoles;

import enums.Department;
import superclasses.employee.Employee;

import java.util.Objects;

public class Tester extends Employee {

    public Tester(String name, int age) {
        super(name, age, "Tester", Department.IT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tester tester)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public void resume() {
        System.out.println("resumeTester: department-" + super.getDepartment() + " name-" + super.getName() + " age-" + super.getAge() + " role-" + super.getRole() + " status-" + super.getStatus().getValue());
    }

}
