package com.solvd.itcompany.company.employeeRoles;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.superclasses.employee.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Developer extends Employee {

    private static final Logger LOGGER = LogManager.getLogger(Developer.class);

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
        LOGGER.info("resumeDeveloper: department-{} name-{} age-{} role-{} successful Projects-{}", super.getDepartment(), super.getName(), super.getAge(), super.getRole(), this.getSuccessfulProjects());
    }

    public int getSuccessfulProjects() {
        return succesfullProjects;
    }
}
