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
import com.solvd.itcompany.threads.FirstThread;
import com.solvd.itcompany.threads.connectionpool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import parser.JacksonParser;
import parser.Jaxbparser;
import parser.StaxParser;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance(5);

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    static void main(String[] args) throws IOException {

        // director (record class)
        Director director = new Director("Barbare", "Gelashvili");

        // company + Runnable lambda
        ITCompany company = new ITCompany("it-company", 2023, director, () -> LOGGER.info("Company created by Barbare Gelashvili. This company is a test. It's not a real one"));

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
            LOGGER.error(e.getMessage());
        }
        ITCompany.getEmployeeResume(tester1);
        ITCompany.getEmployeeResume(tester2);
        ITCompany.getEmployeeResume(developer1);
        ITCompany.getEmployeeResume(developer2);

        // entertainment + exceptions
        try {
            ITCompany.entertainmentPlanning(company, "party", address);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        try {
            ITCompany.entertainmentPlanning(company, "party", address2);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        try {
            ITCompany.entertainmentPlanning(company, "party2", address3);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        // update project
        ITCompany.updateProject(company.getProjects().getFirst(), () -> "in progress");

        // sum of taxes
        ITCompany.sumOfTaxes(company);

        // print how many company we have
        LOGGER.info("We have {} company", ITCompany.getNumberOfCompanies());

        // polymorphism with the interfaces examples
        // project
        company.getBookingDetails(company.getProjects().getFirst());
        company.cancelBooking(company.getProjects().getFirst());

        // entertainment + first list element
        if (!company.getEntertainments().isEmpty()) {
            company.getBookingDetails(company.getEntertainments().get(0));
        }
        if (!company.getEntertainments().isEmpty()) {
            company.cancelBooking(company.getEntertainments().get(0));
        }

        // AutoCloseable
        try (MyResource myResource1 = new MyResource()) {
            LOGGER.info("this is my resource");
        } catch (Exception e) {
            LOGGER.error("exc:-", e);
        } finally {
            LOGGER.info("\n resource closed");
        }

        // map tests
        for (Map.Entry<Problem, String> entry : company.getProblems().entrySet()) {
            LOGGER.info("one of the problem we have is - {} {} ", entry.getKey(), entry.getValue());
        }

        // get first map element
        if (!company.getProblems().isEmpty()) {
            Map.Entry<Problem, String> firstEntry =
                    company.getProblems().entrySet().iterator().next();

            LOGGER.info("first map element - {} -> {} ", firstEntry.getKey(), firstEntry.getValue());
        }

        // get first list element
        if (!company.getAddresses().isEmpty()) {
            LOGGER.info("first list element - {}", company.getAddresses().get(0));
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
        LOGGER.info("company name length is-{}", company.getsmth((e) -> e.getName().length()));

        company.salaryCalculator();

        IntegerFunction<Human> func = (human) -> human.getName().length();
        LOGGER.info("developer-{}s name is made of {} letter", developer1.getName(), func.function(developer1));

        // streams
        Set<Employee> workingEmployees = company.getEmployees().stream()
                .filter(e -> e.getStatus() == EmployeeStatus.IS_WORKING)
                .peek(e -> LOGGER.info("1working employee {}", e.getName()))
                .collect(Collectors.toSet());

        for (Employee employee : workingEmployees) {
            LOGGER.info("2working employee {}", employee.getName());
        }

        boolean samysAreAllWorking = company.getEmployees().stream()
                .filter(employee -> "Samy".equals(employee.getName()))
                .allMatch(employee -> employee.getStatus() == EmployeeStatus.IS_WORKING);

        long samyscount = company.getEmployees().stream()
                .filter(employee -> "Samy".equals(employee.getName()))
                .count();

        if (samysAreAllWorking) LOGGER.info("Samy's Are All Working there's {} Samy", samyscount);
        else LOGGER.info("there's {} Samy, not all works at the moment", samyscount);

        List<String> addressLinks = company.getAddresses().stream()
                .map(tmpAddress -> tmpAddress.mapLink())
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
            LOGGER.info("Samy employee");
            employee.resume();
        });

        // reflection
        try {
            Class<ITCompany> testCompany = (Class<ITCompany>) Class.forName("com.solvd.itcompany.company.ITCompany");
            LOGGER.info("ITCompany CLASS: ");

            // fields
            LOGGER.info("FIELDS:");
            for (Field field : testCompany.getDeclaredFields()) {
                LOGGER.info("Name: {}, Type: {},Modifiers: {}", field.getName(), field.getType(), Modifier.toString(field.getModifiers()));

                // annotation handling
                if (field.isAnnotationPresent(Important.class)) {
                    Important important = field.getAnnotation(Important.class);
                    LOGGER.info("{} has annotation Important with value {} ------------", field.getName(), important.value());
                }
            }

            // constructors
            LOGGER.info("CONSTRUCTORS");
            for (Constructor<?> constructor : testCompany.getDeclaredConstructors()) {
                LOGGER.info("Name: {}, Modifiers: {}", constructor.getName(), Modifier.toString(constructor.getModifiers()));
                LOGGER.info("CParameters: ");
                for (Class<?> param : constructor.getParameterTypes()) {
                    LOGGER.info(" {}", param.getSimpleName());
                }
            }

            // methods
            LOGGER.info("METHODS");
            for (Method method : testCompany.getDeclaredMethods()) {
                LOGGER.info("Name: {}, Modifiers: {}, returnType: {} ", method.getName(), Modifier.toString(method.getModifiers()), method.getReturnType().getSimpleName());
                LOGGER.info("MParameters: ");
                for (Class<?> param : method.getParameterTypes()) {
                    LOGGER.info(" {}", param.getSimpleName());
                }

                // annotation handling
                if (method.isAnnotationPresent(Important.class)) {
                    Important important = method.getAnnotation(Important.class);
                    LOGGER.info("{} has annotation Important with value {} ------------", method.getName(), important.value());
                }
            }

            // create an object
            Constructor<ITCompany> constructor = testCompany.getDeclaredConstructor(String.class, int.class, Director.class, Runnable.class);
            ITCompany ITCompany = constructor.newInstance("name", 1999, director,
                    (Runnable) () -> LOGGER.info("Company created using reflection")
            );

            // call method
            Method setName = testCompany.getDeclaredMethod("setDirector", Director.class);
            setName.setAccessible(true);
            setName.invoke(ITCompany, new Director("Mariam", "shelling"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // count unique words from book
        try {
            WordCounter.countUniqueWords();
        } catch (Exception e) {
            LOGGER.error("Failed to count unique words", e);
        }

        // threads
        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            executor.submit(new FirstThread("Th" + i));
        }

        executor.shutdown();

        try {
            while (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                LOGGER.info("Waiting for all threads to finish...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // CompletableFutures

        ExecutorService executorForFutures = Executors.newFixedThreadPool(5);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hi";
        }, executorForFutures).thenApply(r -> "decrypted " + r);

        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hi";
        }, executorForFutures).thenAccept(r -> LOGGER.info(" f2: {}", r));

        CompletableFuture<Integer> future3 =
                CompletableFuture.supplyAsync(() -> 10, executorForFutures)
                        .thenCombine(
                                CompletableFuture.supplyAsync(() -> 20, executorForFutures),
                                Integer::sum
                        );


        CompletableFuture<Void> future4 =
                CompletableFuture.supplyAsync(() -> {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            return "Hi";
                        }, executorForFutures)
                        .thenAccept(r -> LOGGER.info(" f4: {} world", r));

        CompletionStage<String> future5 =
                CompletableFuture.supplyAsync(() -> "extra task", executorForFutures)
                        .thenApply(r -> r + " done");

        CompletableFuture<String> all =
                CompletableFuture.allOf(future1, future2, future3, future4, future5.toCompletableFuture()).thenApply(v ->
                        future3.join() +
                                " | " +
                                future1.join() +
                                " | " +
                                future5.toCompletableFuture().join()
                );

        LOGGER.info("Futures: {}", all.join());

        LOGGER.info("All tasks finished.");

        executorForFutures.shutdown();


        LOGGER.info("=========== parsers ============");

        File xmlFile = new File("src/main/resources/company.xml");
        File jsonFile = new File("src/main/resources/company.json");

        LOGGER.info("XML File: {}, parsing with Jaxb", xmlFile.getPath());
        Jaxbparser parser = new Jaxbparser();
        ITCompany company1 = parser.parse(xmlFile);

        LOGGER.info("Json File: {}, parsing with Jackson", jsonFile.getPath());
        JacksonParser parser1 = new JacksonParser();
        ITCompany company2 = parser1.parse(jsonFile);

        LOGGER.info("XML File: {}, parsing with Stax", jsonFile.getPath());
        StaxParser parser2 = new StaxParser();
        ITCompany staxc = parser2.parse(xmlFile);

        System.out.println();
    }

}