package company;

import exceptions.BookingException;
import interfaces.Trackable;
import superclasses.Equipment;
import superclasses.Partner;
import superclasses.company.Company;
import superclasses.employee.Employee;

import java.util.*;

public class ITCompany extends Company {

    private static int numberOfCompanies = 0;

    // static field
    static {
        System.out.println("Company Class Loaded");
    }

    BookingService bookingService = new BookingService();

    private List<Address> addresses;
    private Set<Employee> employees;
    private List<Entertainment> entertainments;
    private List<Equipment> equipment;
    private Set<Partner> partners;
    private Map<Problem, String> problems;
    private List<Project> projects;
    private List<Tax> taxes;

    public ITCompany(String name, int year) {
        super(name, year, "IT");
        projects = new ArrayList<>();
        employees = new HashSet<>();
        partners = new HashSet<>();
        addresses = new ArrayList<>();
        taxes = new ArrayList<>();
        entertainments = new ArrayList<>();
        equipment = new ArrayList<>();
        problems = new HashMap<>();
        numberOfCompanies++;
    }

    // static getters and setters
    public static int getNumberOfCompanies() {
        return numberOfCompanies;
    }

    public static void setNumberOfCompanies(int numberOfCompanies) {
        ITCompany.numberOfCompanies = numberOfCompanies;
    }

    // functions
    public static void updateProject(Project project, String status) {
        ITCompanyFunctions.updateProject(project, status);
    }

    public static void sumOfTaxes(ITCompany company) {
        ITCompanyFunctions.sumOfTaxes(company);
    }

    public static void entertainmentPlanning(ITCompany company, String name, Address address) {
        ITCompanyFunctions.entertainmentPlanning(company, name, address);
    }

    public static void bookService(Customer customer, ITCompany company, String projectName) throws BookingException {
        BookingService.bookService(customer, company, projectName);
    }

    public static void getResume(Employee employee) {
        BookingService.employeeResume(employee);
    }

    public void cancelBooking(Trackable trackable) {
        bookingService.cancelBooking(trackable);
    }

    public void getBookingDetails(Trackable trackable) {
        bookingService.getBookingDetails(trackable);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " there's " + getNumberOfCompanies() + " companies";
    }

    // adding stuff
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void addTax(Tax tax) {
        taxes.add(tax);
    }

    public void addPartner(Partner partner) {
        partners.add(partner);
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }

    public void addEntertainment(String name, Address address) {
        entertainments.add(new Entertainment(name, address));
    }

    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    public void addProblems(Problem problem) {
        problems.put(problem, problem.getName());
    }

    // setters and getters
    public BookingService getBookingService() {
        return bookingService;
    }

    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public List<Entertainment> getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(List<Entertainment> entertainments) {
        this.entertainments = entertainments;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Set<Partner> getPartners() {
        return partners;
    }

    public void setPartners(Set<Partner> partners) {
        this.partners = partners;
    }

    public Map<Problem, String> getProblems() {
        return problems;
    }

    public void setProblems(Map<Problem, String> problems) {
        this.problems = problems;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Tax> taxes) {
        this.taxes = taxes;
    }
}
