package company;

import java.math.BigDecimal;
import java.util.Objects;

class CompanyFunctions {

    public static void updateProject(Project project, String status) {
        if (Objects.equals(project.getStatus(), status)) {
            System.out.println("Project wasn't updated, it's" + project.getStatus());
        } else {
            project.setStatus(status);
            System.out.println("Project updated - to " + status);
        }
    }

    public static BigDecimal sumOfTaxes(Company company) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < company.getTaxes().length; i++) {
            sum = sum.add(company.getTaxes()[i].getPrice());
        }
        System.out.println("company-" + company.getName() + " has Tax: " + sum);
        return sum;
    }

    public static void entertainmentPlanning(Company company, String name, String location) {
        boolean alreadyPlanned = false;
        for (int i = 0; i < company.getEntertainments().length; i++) {
            if (Objects.equals(company.getEntertainments()[i].getName(), name) && Objects.equals(company.getEntertainments()[i].getLocation(), location)) {
                alreadyPlanned = true;
                break;
            }
        }
        if (!alreadyPlanned) {
            company.addEntertainment(name, location);
            System.out.println(name + " - entertainment planned successfully");
        } else {
            System.out.println(name + " - entertainment already planned");
        }
    }

    static Team teamDistribution(Company company, String name) {
        int j = 0;
        Team team = new Team(name);
        for (int i = 0; i < company.getEmployees().length; i++) {
            if (!company.getEmployees()[i].isWorking()) {
                team.addEmployee(company.getEmployees()[i]);
                company.getEmployees()[i].setWorking(true);
                j++;
                if (j == 2) break;
            }
        }
        return team;
    }
}
