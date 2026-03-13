import company.*;

import java.math.BigDecimal;

public class Main {

    static void main(String[] args) {

        Company company = new Company("it-company");

        // employees
        Employee mari = new Employee("Mari", "Developer");
        Employee sam = new Employee("Sam", "Developer");
        Employee samy = new Employee("Samy", "Developer");
        Employee jack = new Employee("Samy", "Developer");
        Employee nick = new Employee("Samy", "Developer");
        Employee liza = new Employee("Samy", "Developer");

        // adding employees
        company.addEmployee(mari);
        company.addEmployee(sam);
        company.addEmployee(samy);
        company.addEmployee(jack);
        company.addEmployee(nick);
        company.addEmployee(liza);

        // addresses
        Address address = new Address("street of nowhere");
        Address address2 = new Address("street of nowhere2");
        Address address3 = new Address("street of nowhere3");

        // adding addresses
        company.addAddress(address);
        company.addAddress(address2);
        company.addAddress(address3);

        // Equipment
        Equipment equipment = new Equipment("phone", "electronic");
        Equipment equipment2 = new Equipment("laptop", "electronic2");

        // adding equipment
        company.addEquipment(equipment);
        company.addEquipment(equipment2);

        // partner
        Partner partner = new Partner("it-company2", "company");
        Partner partner2 = new Partner("Nino", "person");

        // adding partner
        company.addPartner(partner);
        company.addPartner(partner2);

        // problems
        Problem problem = new Problem("error-on-line-2", "project-1");
        Problem problem2 = new Problem("doesnt-turn-on", "equipment-2");

        // adding problems
        company.addProblems(problem);
        company.addProblems(problem2);

        // Taxes
        Tax tax = new Tax(new BigDecimal("222.3"), "equipment");
        Tax tax2 = new Tax(new BigDecimal("3244.3"), "entertainment");

        // adding taxes
        company.addTax(tax);
        company.addTax(tax2);

        // customer
        Customer customer = new Customer("Barbare");

        // booking service
        Company.bookService(customer, company, "new my project");

        // entertainment
        Company.entertainmentPlanning(company, "party", "street of nowhere");
        Company.entertainmentPlanning(company, "party", "street of nowhere");
        Company.entertainmentPlanning(company, "party2", "street of nowhere");

        // update project
        Company.updateProject(customer.getProject(), "in-progress");

        // sum of taxes
        Company.sumOfTaxes(company);

        // print how many company we have
        System.out.println("We have " + Company.getNumberOfCompanies() + " company");
    }
}
