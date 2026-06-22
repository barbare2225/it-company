package com.solvd.itcompany.company.employeeRoles;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.superclasses.employee.Employee;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Developer extends Employee {

    private static final Logger LOGGER = LogManager.getLogger(Developer.class);

    private int successfulProjects;

    public Developer(String name, int age, int successfulProjects) {
        super(name, age, "Developer", Department.IT);
        this.successfulProjects = successfulProjects;
    }

    public Developer() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer developer)) return false;
        return super.equals(o) && Objects.equals(successfulProjects, developer.successfulProjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), successfulProjects);
    }

    @Override
    public void resume() {
        LOGGER.info("resumeDeveloper: department-{} name-{} age-{} role-{} successful Projects-{}", super.getDepartment(), super.getName(), super.getAge(), super.getRole(), this.getSuccessfulProjects());
    }

    public int getSuccessfulProjects() {
        return successfulProjects;
    }

    public void setSuccessfulProjects(int successfulProjects) {
        this.successfulProjects = successfulProjects;
    }
}
