package com.solvd.itcompany.company.employeeRoles;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.superclasses.employee.Employee;

import java.util.Objects;

public class Recruiter extends Employee {

    public Recruiter(String name, int age) {
        super(name, age, "Recruiter", Department.HR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recruiter recruiter)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public void resume() {
        System.out.println("resumeRecruiter:  department-" + super.getDepartment() + " name-" + super.getName() + " age-" + super.getAge() + " role-" + super.getRole() + " status-" + super.getStatus().getValue());
    }
}
