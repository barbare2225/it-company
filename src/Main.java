import company.*;
import company.employeeRoles.Developer;
import company.employeeRoles.Tester;
import company.equipment.ElectronicDevice;
import company.equipment.MechanicalDevice;
import company.partners.CompanyPartner;
import company.partners.HumanPartner;
import generics.Order;
import generics.Room;
import myresource.MyResource;
import superclasses.Equipment;
import superclasses.Partner;
import superclasses.employee.Employee;

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
        company.addEmployee(developer2);
        company.addEmployee(developer3);
        company.addEmployee(developer1);
        company.addEmployee(tester2);
        company.addEmployee(tester1);
        company.addEmployee(tester3);

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

        // entertainment + first set element
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
        // Entertainment Room
        Room<Employee> funRoom = new Room<>("Entertainment Room");
        funRoom.add(developer1);
        funRoom.add(tester1);

        // old Equipment room
        Room<Equipment> oldEquipmentRoom = new Room<>("old equipment Room");
        oldEquipmentRoom.add(equipment2);

        // Order for project
        Order<Project> projectOrder = new Order<>(company.getProjects().get(0).getName(), company.getProjects().get(0), developer3);

        // order new equipment
        Order<Equipment> equipmentOrder = new Order<>("order new computer", equipment2, tester2);
    }
}
