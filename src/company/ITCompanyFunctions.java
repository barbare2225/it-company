package company;

import exceptions.DuplicateException;
import superclasses.employee.Employee;

import java.math.BigDecimal;
import java.util.Objects;

class ITCompanyFunctions {

    public static void updateProject(Project project, String status) {
        if (Objects.equals(project.getStatus(), status)) {
            System.out.println("Project wasn't updated, it's" + project.getStatus());
        } else {
            project.setStatus(status);
            System.out.println("Project updated - to " + status);
        }
    }

    public static BigDecimal sumOfTaxes(ITCompany company) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < company.getTaxes().size(); i++) {
            sum = sum.add(company.getTaxes().get(i).getPrice());
        }
        System.out.println("company-" + company.getName() + " has Tax: " + sum);
        return sum;
    }

    public static void entertainmentPlanning(ITCompany company, String name, Address address) {
        boolean alreadyPlanned = false;
        for (int i = 0; i < company.getEntertainments().size(); i++) {
            if (Objects.equals(company.getEntertainments().get(i).getName(), name)) {
                alreadyPlanned = true;
                break;
            }
        }
        if (!alreadyPlanned) {
            company.getEntertainments().add(new Entertainment(name, address));
            System.out.println(name + " - entertainment planned successfully");
        } else {
//            System.out.println(name + " - entertainment already planned");
            throw new DuplicateException("entertainment already planned");
        }
    }

    public static Team teamDistribution(ITCompany company, String name) {
        int j = 0;
        Team team = new Team(name);
        for (Employee employee : company.getEmployees()) {
            if (!employee.isWorking()) {
                team.addEmployee(employee);
                employee.setWorking(true);
                j++;
                if (j == 2) break;
            }
        }
        return team;
    }
}
