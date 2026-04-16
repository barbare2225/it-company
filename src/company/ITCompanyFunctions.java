package company;

import enums.EmployeeStatus;
import exceptions.DuplicateException;
import functionalinterfaces.SalaryCalculator;
import functionalinterfaces.TriConsumer;
import superclasses.employee.Employee;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

class ITCompanyFunctions {

    public static void updateProject(Project project, Supplier<String> supplier, Consumer<Project> consumer, BiConsumer<Project, String> projectUpdater) {
        consumer.accept(project);
        if (Objects.equals(project.getStatus(), supplier.get())) {
            System.out.println("Project wasn't updated, it's" + project.getStatus());
        } else {
            projectUpdater.accept(project, supplier.get());
            System.out.println("Project updated - to " + supplier.get());
        }
    }

    public static BigDecimal sumOfTaxes(ITCompany company, BiFunction<ITCompany, Integer, BigDecimal> taxesCalculator) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < company.getTaxes().size(); i++) {
            sum = sum.add(taxesCalculator.apply(company, i));
        }
        System.out.println("company-" + company.getName() + " has Tax: " + sum);
        return sum;
    }

    public static void entertainmentPlanning(ITCompany company, String name, Address address, TriConsumer<ITCompany, String, Address> consumer) {

        boolean alreadyPlanned = false;
        for (int i = 0; i < company.getEntertainments().size(); i++) {
            if (Objects.equals(company.getEntertainments().get(i).getName(), name)) {
                alreadyPlanned = true;
                break;
            }
        }
        if (!alreadyPlanned) {
            consumer.accept(company, name, address); // adds new entertainment
            System.out.println(name + " - entertainment planned successfully");
        } else {
            throw new DuplicateException(name + " - entertainment already planned");
        }
    }

    public static Team teamDistribution(ITCompany company, String name) {
        int j = 0;
        Team team = new Team(name);
        for (Employee employee : company.getEmployees()) {
            if (!employee.getStatus().isActive()) {
                team.addEmployee(employee);
                employee.setStatus(EmployeeStatus.IS_WORKING);
                j++;
                if (j == 2) break;
            }
        }
        return team;
    }

    public static void salaryCalculator(Set<Employee> employees, SalaryCalculator salaryCalculator) {
        for (Employee employee : employees) {
            salaryCalculator.calculateSalary(employee);
        }
    }
}
