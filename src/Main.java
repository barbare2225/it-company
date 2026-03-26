import company.*;
import company.employeeRoles.Developer;
import company.employeeRoles.Tester;
import company.equipment.ElectronicDevice;
import company.equipment.MechanicalDevice;
import company.partners.CompanyPartner;
import company.partners.HumanPartner;
import myResource.MyResource;
import superClasses.Equipment;
import superClasses.Partner;
import superClasses.employee.Employee;

import java.math.BigDecimal;

public class Main {

    static void main(String[] args) {

        ITCompany company = new ITCompany("it-company", 2023);

        // employees
        Employee Tester1 = new Tester("Mari", 19);
        Employee Tester2 = new Tester("Sam", 20);
        Employee Developer1 = new Developer("Samy", 21, 1);
        Employee Developer2 = new Developer("Samy", 34, 3);
        Employee Tester3 = new Tester("Samy", 40);
        Employee Developer3 = new Developer("Samy", 43, 4);

        // adding employees
        company.addEmployee(Developer2);
        company.addEmployee(Developer3);
        company.addEmployee(Developer1);
        company.addEmployee(Tester2);
        company.addEmployee(Tester1);
        company.addEmployee(Tester3);

        // addresses
        Address address = new Address("street of nowhere", "Tbilisi", "Georgia");
        Address address2 = new Address("street of nowhere2", "Tbilisi", "Georgia");
        Address address3 = new Address("street of nowhere3", "Tbilisi", "Georgia");

        // adding addresses
        company.addAddress(address);
        company.addAddress(address2);
        company.addAddress(address3);

        // Equipment
        Equipment equipment = new MechanicalDevice("phone", true);
        Equipment equipment2 = new ElectronicDevice("laptop", 3);

        // adding equipment
        company.addEquipment(equipment);
        company.addEquipment(equipment2);

        // partner
        Partner partner = new CompanyPartner("slay-QUINS", 2025, "cosmetic-company");
        Partner partner2 = new HumanPartner("Nino");

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
        Customer customer = new Customer("Barbare", 20);

        // booking service + exception
        try {
            ITCompany.bookService(customer, company, "new my project");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ITCompany.getResume(Tester1);
        ITCompany.getResume(Tester2);
        ITCompany.getResume(Developer1);
        ITCompany.getResume(Developer2);

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

        // entertainment
        company.getBookingDetails(company.getEntertainments()[0]);
        company.cancelBooking(company.getEntertainments()[0]);

        // AutoCloseable
        try (MyResource myResource1 = new MyResource()) {
            System.out.println("this is my resource");
        } catch (Exception e) {
            System.out.println("exc:-" + e.getMessage());
        } finally {
            System.out.println("\n resource closed");
        }
    }
}
