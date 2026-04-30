package company.employeeRoles;

import enums.Department;
import superclasses.employee.Employee;

import java.util.Objects;

public class Developer extends Employee {

    private final int succesfullProjects;

    public Developer(String name, int age, int succesfullProjects) {
        super(name, age, "Developer", Department.IT);
        this.succesfullProjects = succesfullProjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer developer)) return false;
        return super.equals(o) && Objects.equals(succesfullProjects, developer.succesfullProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), succesfullProjects);
    }

    @Override
    public void resume() {
        System.out.println("resumeDeveloper: department-" + super.getDepartment() + " name-" + super.getName() + " age-" + super.getAge() + " role-" + super.getRole() + " succesfullProjects-" + this.succesfullProjects);
    }

    public int getSuccesfullProjects() {
        return succesfullProjects;
    }
}
