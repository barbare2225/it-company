import company.*;
import company.employeeRoles.Developer;
import company.employeeRoles.Tester;
import company.equipment.ElectronicDevice;
import company.equipment.MechanicalDevice;
import company.partners.CompanyPartner;
import company.partners.HumanPartner;
import myresource.MyResource;
import superclasses.Equipment;
import superclasses.Partner;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    static void main(String[] args) {

        ITCompany company = new ITCompany("it-company", 2023);

        // employees
        Tester tester1 = new Tester("Mari", 19);
        Tester tester2 = new Tester("Sam", 20);
        Developer developer1 = new Developer("Samy", 21, 1);
        Developer developer2 = new Developer("Samy", 34, 3);
        Tester tester3 = new Tester("Samy", 40);
        Developer developer3 = new Developer("Samy", 43, 4);

        // adding employees
        company.getEmployees().add(developer2);
        company.getEmployees().add(developer3);
        company.getEmployees().add(developer1);
        company.getEmployees().add(tester2);
        company.getEmployees().add(tester1);
        company.getEmployees().add(tester3);

        // addresses
        Address address = new Address("street of nowhere", "Tbilisi", "Georgia");
        Address address2 = new Address("street of nowhere2", "Tbilisi", "Georgia");
        Address address3 = new Address("street of nowhere3", "Tbilisi", "Georgia");

        // adding addresses
        company.getAddresses().add(address);
        company.getAddresses().add(address2);
        company.getAddresses().add(address3);

        // Equipment
        Equipment equipment = new MechanicalDevice("phone", true);
        Equipment equipment2 = new ElectronicDevice("laptop", 3);

        // adding equipment
        company.getEquipment().add(equipment);
        company.getEquipment().add(equipment2);

        // partner
        Partner partner = new CompanyPartner("slay-QUINS", 2025);
        Partner partner2 = new HumanPartner("Nino", 20);
        Partner partner4 = new HumanPartner("Nino", 20);

        // adding partner
        company.getPartners().add(partner);
        company.getPartners().add(partner2);
        company.getPartners().add(partner4);

        // problems
        Problem problem = new Problem("error-on-line-2", "project-1");
        Problem problem2 = new Problem("doesnt-turn-on", "equipment-2");
        Problem problem3 = new Problem("doesnt-turn-on", "equipment-2");

        // adding problems
        company.getProblems().put(problem, problem.getName());
        company.getProblems().put(problem2, problem2.getName());
        company.getProblems().put(problem3, problem3.getName());

        // Taxes
        Tax tax = new Tax(new BigDecimal("222.3"), "equipment");
        Tax tax2 = new Tax(new BigDecimal("3244.3"), "entertainment");

        // adding taxes
        company.getTaxes().add(tax);
        company.getTaxes().add(tax2);

        // customer
        Customer customer = new Customer("Barbare", 20);

        // booking service + exception
        try {
            ITCompany.bookService(customer, company, "new my project");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ITCompany.getResume(tester1);
        ITCompany.getResume(tester2);
        ITCompany.getResume(developer1);
        ITCompany.getResume(developer2);

        // entertainment + exceptions
        try {
            ITCompany.entertainmentPlanning(company, "party", address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ITCompany.entertainmentPlanning(company, "party", address2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            ITCompany.entertainmentPlanning(company, "party2", address3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // update project
        ITCompany.updateProject(customer.getProject(), "in-progress");

        // sum of taxes
        ITCompany.sumOfTaxes(company);

        // print how many company we have
        System.out.println("We have " + ITCompany.getNumberOfCompanies() + " company\n");

        // polymorphism with the interfaces examples
        // project
        company.getBookingDetails(customer.getProject());
        company.cancelBooking(customer.getProject());

        // entertainment + first list element
        if (!company.getEntertainments().isEmpty()) {
            company.getBookingDetails(company.getEntertainments().get(0));
        }
        if (!company.getEntertainments().isEmpty()) {
            company.cancelBooking(company.getEntertainments().get(0));
        }

        // AutoCloseable
        try (MyResource myResource1 = new MyResource()) {
            System.out.println("this is my resource");
        } catch (Exception e) {
            System.out.println("exc:-" + e.getMessage());
        } finally {
            System.out.println("\n resource closed");
        }

        // map tests
        System.out.println();
        for (Map.Entry<Problem, String> entry : company.getProblems().entrySet()) {
            System.out.println("one of the problem we have is - " + entry.getKey() + " " + entry.getValue());
        }

        // get first map element
        if (!company.getProblems().isEmpty()) {
            Map.Entry<Problem, String> firstEntry =
                    company.getProblems().entrySet().iterator().next();

            System.out.println("first map element - " + firstEntry.getKey() + " -> " + firstEntry.getValue());
        }

        // get first list element
        if (!company.getAddresses().isEmpty()) {
            System.out.println("first list element - " + company.getAddresses().get(0));
        }

        // generics
        // room
        company.getDevRoom().add(developer1);
        company.getDevRoom().add(developer2);

        company.getTesterRoom().add(tester1);
        company.getTesterRoom().add(tester2);

        // Order
        company.getOrderEntertainment().addItem(new Entertainment("party party", address3));
        if (!company.getEmployees().isEmpty()) {
            company.getOrderEntertainment().addEmployeeAsignedTo(company.getEmployees().iterator().next());
        }

        company.getEquipmentOrder().addItem(equipment2);
        if (!company.getEmployees().isEmpty()) {
            company.getEquipmentOrder().addEmployeeAsignedTo(company.getEmployees().iterator().next());
        }
    }
}
