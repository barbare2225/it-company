package com.solvd.itcompany.company;

import com.solvd.itcompany.enums.EmployeeStatus;
import com.solvd.itcompany.exceptions.DuplicateException;
import com.solvd.itcompany.functionalinterfaces.SalaryCalculator;
import com.solvd.itcompany.functionalinterfaces.TriConsumer;
import com.solvd.itcompany.superclasses.employee.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

class ITCompanyFunctions {

    private static final Logger LOGGER = LogManager.getLogger(ITCompanyFunctions.class);

    public static void updateProject(Project project, Supplier<String> supplier, Consumer<Project> consumer, BiConsumer<Project, String> projectUpdater) {
        consumer.accept(project);
        if (Objects.equals(project.getStatus(), supplier.get())) {
            LOGGER.info("Project wasn't updated, it's {}", project.getStatus());
        } else {
            projectUpdater.accept(project, supplier.get());
            LOGGER.info("Project updated - to {}", supplier.get());
        }
    }

    public static BigDecimal sumOfTaxes(ITCompany company, BiFunction<ITCompany, Integer, BigDecimal> taxesCalculator) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < company.getTaxes().size(); i++) {
            sum = sum.add(taxesCalculator.apply(company, i));
        }
        LOGGER.info("company-{} has Tax: {}", company.getName(), sum);
        return sum;
    }

    public static void entertainmentPlanning(ITCompany company, String name, Address address, TriConsumer<ITCompany, String, Address> consumer) {

        boolean alreadyPlanned = company.getEntertainments().stream()
                .anyMatch(e -> Objects.equals(e.getName(), name));

        if (!alreadyPlanned) {
            consumer.accept(company, name, address); // adds new entertainment
            LOGGER.info("{} - entertainment planned successfully",name );
        } else {
            throw new DuplicateException(name + " - entertainment already planned");
        }
    }

    public static Team teamDistribution(ITCompany company, String name) {
        int j = 0;
        Team team = new Team(name);
        company.getEmployees().stream()
                .filter(employee -> !employee.getStatus().isActive())
                .limit(2)
                .forEach(employee -> {
                    team.addEmployee(employee);
                    employee.setStatus(EmployeeStatus.IS_WORKING);
                });
        return team;
    }

    public static void salaryCalculator(Set<Employee> employees, SalaryCalculator salaryCalculator) {
        for (Employee employee : employees) {
            salaryCalculator.calculateSalary(employee);
        }
    }
}
