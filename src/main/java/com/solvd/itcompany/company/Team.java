package com.solvd.itcompany.company;

import com.solvd.itcompany.company.employeeRoles.Developer;
import com.solvd.itcompany.company.employeeRoles.Recruiter;
import com.solvd.itcompany.company.employeeRoles.Tester;
import com.solvd.itcompany.superclasses.employee.Employee;
import jakarta.xml.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
public class Team {

    private String name;
    @XmlElementWrapper(name = "employees")
    @XmlElements({
            @XmlElement(name = "developer", type = Developer.class),
            @XmlElement(name = "recruiter", type = Recruiter.class),
            @XmlElement(name = "tester", type = Tester.class),
    })
    private Set<Employee> employees;

    public Team(String name) {
        this.name = name;
        employees = new HashSet<>();
    }

    public Team() {
    }

    // functions
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
