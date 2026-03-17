import company.*;
import company.employeeRoles.Developer;
import company.employeeRoles.Tester;
import company.equipment.ElectronicDevice;
import company.equipment.MechanicalDevice;
import company.partners.CompanyPartner;
import company.partners.HumanPartner;
import superClasses.Employee;
import superClasses.Equipment;
import superClasses.Partner;

import java.math.BigDecimal;

public class Main {

    static void main(String[] args) {

        ITCompany company = new ITCompany("it-company", 2023);

        // employees
        Employee Tester1 = new Tester("Mari");
        Employee Tester2 = new Tester("Sam");
        Employee Developer1 = new Developer("Samy", 1);
        Employee Developer2 = new Developer("Samy", 3);
        Employee Tester3 = new Tester("Samy");
        Employee Developer3 = new Developer("Samy", 4);

        // adding employees
        company.addEmployee(Developer2);
        company.addEmployee(Developer3);
        company.addEmployee(Developer1);
        company.addEmployee(Tester2);
        company.addEmployee(Tester1);
        company.addEmployee(Tester3);

        // addresses
        Address address = new Address("street of nowhere");
        Address address2 = new Address("street of nowhere2");
        Address address3 = new Address("street of nowhere3");

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
        Customer customer = new Customer("Barbare");

        // booking service
        ITCompany.bookService(customer, company, "new my project");
        ITCompany.getResume(Tester1);
        ITCompany.getResume(Tester2);
        ITCompany.getResume(Developer1);
        ITCompany.getResume(Developer2);

        // entertainment
        ITCompany.entertainmentPlanning(company, "party", "street of nowhere");
        ITCompany.entertainmentPlanning(company, "party", "street of nowhere");
        ITCompany.entertainmentPlanning(company, "party2", "street of nowhere");

        // update project
        ITCompany.updateProject(customer.getProject(), "in-progress");

        // sum of taxes
        ITCompany.sumOfTaxes(company);

        // print how many company we have
        System.out.println("We have " + ITCompany.getNumberOfCompanies() + " company");
    }
}
