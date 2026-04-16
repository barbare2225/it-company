package functionalinterfaces;

import superclasses.employee.Employee;

@FunctionalInterface
public interface SalaryCalculator {
    void calculateSalary(Employee employee);
}
