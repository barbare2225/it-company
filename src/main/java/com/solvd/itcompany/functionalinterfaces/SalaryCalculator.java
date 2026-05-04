package com.solvd.itcompany.functionalinterfaces;

import com.solvd.itcompany.superclasses.employee.Employee;

@FunctionalInterface
public interface SalaryCalculator {

    void calculateSalary(Employee employee);

}
