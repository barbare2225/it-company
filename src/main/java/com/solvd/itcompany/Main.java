package com.solvd.itcompany;

import com.solvd.itcompany.annotation.Important;
import com.solvd.itcompany.company.*;
import com.solvd.itcompany.company.employeeRoles.Developer;
import com.solvd.itcompany.company.employeeRoles.Tester;
import com.solvd.itcompany.company.equipment.ElectronicDevice;
import com.solvd.itcompany.company.equipment.MechanicalDevice;
import com.solvd.itcompany.company.partners.CompanyPartner;
import com.solvd.itcompany.company.partners.HumanPartner;
import com.solvd.itcompany.enums.EmployeeStatus;
import com.solvd.itcompany.functionalinterfaces.IntegerFunction;
import com.solvd.itcompany.myresource.MyResource;
import com.solvd.itcompany.record.Director;
import com.solvd.itcompany.superclasses.Equipment;
import com.solvd.itcompany.superclasses.Human;
import com.solvd.itcompany.superclasses.Partner;
import com.solvd.itcompany.superclasses.employee.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    static void main(String[] args) {

        // director (record class)
        Director director = new Director("Barbare", "Gelashvili");

        // company + Runnable lambda
        ITCompany company = new ITCompany("it-company", 2023, director, () -> System.out.println("Company created by Barbare Gelashvili. This company is a test. It's not a real one"));

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
        ITCompany.getEmployeeResume(tester1);
        ITCompany.getEmployeeResume(tester2);
        ITCompany.getEmployeeResume(developer1);
        ITCompany.getEmployeeResume(developer2);

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
        ITCompany.updateProject(customer.getProject(), () -> "in progress");

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

        // lambdas
        System.out.println("company name length is-" + company.getsmth((e) -> e.getName().length()));

        company.salaryCalculator();

        IntegerFunction<Human> func = (human) -> human.getName().length();
        System.out.println("developer-" + developer1.getName() + "'s name is made of " + func.function(developer1) + " letter");

        // streams
        Set<Employee> workingEmployees = company.getEmployees().stream()
                .filter(e -> e.getStatus() == EmployeeStatus.IS_WORKING)
                .peek(e -> System.out.println("1working employee " + e.getName()))
                .collect(Collectors.toSet());

        for (Employee employee : workingEmployees) {
            System.out.println("2working employee " + employee.getName());
        }

        boolean samysAreAllWorking = company.getEmployees().stream()
                .filter(employee -> "Samy".equals(employee.getName()))
                .allMatch(employee -> employee.getStatus() == EmployeeStatus.IS_WORKING);

        long samyscount = company.getEmployees().stream()
                .filter(employee -> "Samy".equals(employee.getName()))
                .count();

        if (samysAreAllWorking) System.out.println("Samy's Are All Working there's " + samyscount + " Samy");
        else System.out.println("there's " + samyscount + " Samy, not all works at the moment");

        List<String> addressLinks = company.getAddresses().stream()
                .map(addres -> addres.mapLink())
                .toList();

        // Optional + 7th stream
        Optional<Employee> firstSamy = company.getProjects().stream()
                .flatMap(project -> project.getTeam().getEmployees().stream())
                .filter(employee -> "Samy".equals(employee.getName()))
                .findFirst();

        int age = firstSamy
                .map(employee -> employee.getAge())
                .orElseThrow(() -> new RuntimeException("No Result"));

        firstSamy.ifPresent(employee -> {
            System.out.println("samy employee");
            employee.resume();
        });

        // reflection
        try {
            Class<ITCompany> testCompany = (Class<ITCompany>) Class.forName("com.solvd.itcompany.company.ITCompany");
            System.out.println("ITCompany CLASS: ");

            // fields
            System.out.println("FIELDS:");
            for (Field field : testCompany.getDeclaredFields()) {
                System.out.print("Name: " + field.getName());
                System.out.print("Type: " + field.getType());
                System.out.println("Modifiers: " + Modifier.toString(field.getModifiers()));

                // annotation handling
                if (field.isAnnotationPresent(Important.class)) {
                    Important important = field.getAnnotation(Important.class);
                    System.out.println(field.getName() + " has annotation Important with value " + important.value() + "------------");
                }
            }

            // constructors
            System.out.println("CONSTRUCTORS");
            for (Constructor<?> constructor : testCompany.getDeclaredConstructors()) {
                System.out.println("Name: " + constructor.getName());
                System.out.println("Modifiers: " + Modifier.toString(constructor.getModifiers()));
                System.out.print("Parameters: ");
                for (Class<?> param : constructor.getParameterTypes()) {
                    System.out.print(param.getSimpleName() + " ");
                }
            }
            System.out.println();

            // methods
            System.out.println("METHODS");
            for (Method method : testCompany.getDeclaredMethods()) {
                System.out.println("Name: " + method.getName());
                System.out.println("Modifiers: " + Modifier.toString(method.getModifiers()));
                System.out.println("returnType: " + method.getReturnType().getSimpleName());
                System.out.print("Parameters: ");
                for (Class<?> param : method.getParameterTypes()) {
                    System.out.print(param.getSimpleName() + " ");
                }
                System.out.println();

                // annotation handling
                if (method.isAnnotationPresent(Important.class)) {
                    Important important = method.getAnnotation(Important.class);
                    System.out.println(method.getName() + " has annotation Important with value " + important.value() + "------------");
                }
            }

            // create an object
            Constructor<ITCompany> constructor = testCompany.getDeclaredConstructor(String.class, int.class, Director.class, Runnable.class);
            ITCompany ITCompany = constructor.newInstance("name", 1999, director,
                    (Runnable) () -> System.out.println("Company created using reflection")
            );

            // call method
            Method setName = testCompany.getDeclaredMethod("setDirector", Director.class);
            setName.setAccessible(true);
            setName.invoke(ITCompany, new Director("Mariam", "shelling"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}