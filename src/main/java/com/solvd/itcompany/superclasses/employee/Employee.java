package com.solvd.itcompany.superclasses.employee;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.solvd.itcompany.company.Project;
import com.solvd.itcompany.company.employeeRoles.Developer;
import com.solvd.itcompany.company.employeeRoles.Recruiter;
import com.solvd.itcompany.company.employeeRoles.Tester;
import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.enums.EmployeeStatus;
import com.solvd.itcompany.enums.Rating;
import com.solvd.itcompany.exceptions.InvalidSalaryException;
import com.solvd.itcompany.interfaces.Payable;
import com.solvd.itcompany.interfaces.Workable;
import com.solvd.itcompany.superclasses.Human;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "role",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Developer.class, name = "Developer"),
        @JsonSubTypes.Type(value = Tester.class, name = "Tester"),
        @JsonSubTypes.Type(value = Recruiter.class, name = "Recruiter")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends Human implements Payable, Workable {

    private static final Logger LOGGER = LogManager.getLogger(Employee.class);

    private String role;
    private EmployeeStatus status;
    private Rating rating;
    private Department department;

    public Employee(String name, int age, String role, Department department) {
        super(name, age);
        this.role = role;
        status = EmployeeStatus.IS_NOT_WORKING;
        rating = Rating.NULL;
        this.department = department;
    }

    public Employee() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(role, employee.role) && Objects.equals(status, employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, status);
    }

    @Override
    public void receiveSalary(double amount) {
        if (amount < 2000) {
            throw new InvalidSalaryException("Salary amount must be greater than 2000, not-" + amount);
        } else {
            LOGGER.info("Employee received a salary of {}", amount);
        }
    }

    @Override
    public void startWork() {
        LOGGER.info("Employee is starting work");
    }

    @Override
    public void stopWork() {
        LOGGER.info("Employee is stopping working");
    }

    @Override
    public void submitTask(Project project) {
        LOGGER.info("Employee submitting project:{}", project.getName());
    }

    @Override
    public void resume() {
        LOGGER.info("name is {} age is-{} Role is -{}", super.getName(), super.getAge(), this.role);
    }

    // getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
