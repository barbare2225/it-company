package com.solvd.itcompany.company.employeeRoles;

import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.superclasses.employee.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Tester extends Employee {

    private static final Logger LOGGER = LogManager.getLogger(Tester.class);

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
        LOGGER.info("resumeTester: department-{} name-{} age-{} role-{} status-{}" ,super.getDepartment() , super.getName() , super.getAge(), super.getRole() , super.getStatus().getValue());
    }

}
