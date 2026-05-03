package company;

import annotation.Important;
import company.employeeRoles.Developer;
import company.employeeRoles.Tester;
import enums.CompanyType;
import enums.ProjectStatus;
import exceptions.BookingException;
import generics.Order;
import generics.Room;
import interfaces.Trackable;
import record.Director;
import superclasses.Equipment;
import superclasses.Partner;
import superclasses.company.Company;
import superclasses.employee.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ITCompany extends Company {

    private static int numberOfCompanies = 0;

    // static field
    static {
        System.out.println("Company Class Loaded");
    }

    private BookingService bookingService = new BookingService();

    @Important(value = "Director of this company")
    private Director director;
    private List<Address> addresses;
    private Set<Employee> employees;
    private List<Entertainment> entertainments;
    private List<Equipment> equipment;
    private Set<Partner> partners;
    private Map<Problem, String> problems;
    private List<Project> projects;
    private List<Tax> taxes;
    private Room<Developer> devRoom;
    private Room<Tester> testerRoom;
    private Order<Entertainment> orderEntertainment;
    private Order<Equipment> equipmentOrder;

    public ITCompany(String name, int year, Director director, Runnable run) {
        run.run();
        this.director = director;
        super(name, year, CompanyType.IT);
        projects = new ArrayList<>();
        employees = new HashSet<>();
        partners = new HashSet<>();
        addresses = new ArrayList<>();
        taxes = new ArrayList<>();
        entertainments = new ArrayList<>();
        equipment = new ArrayList<>();
        problems = new HashMap<>();
        devRoom = new Room<>("developers room");
        testerRoom = new Room<>("testers room");
        orderEntertainment = new Order<>("orders Entertainment");
        equipmentOrder = new Order<>("orders equipment");
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
    @Important(value = "project status updater")
    public static void updateProject(Project project, Supplier<String> supplier) {
        ITCompanyFunctions.updateProject(project, supplier,
                (e) -> System.out.println("trying to update project-" + e.getName() + " current status-" + e.getStatus()),
                (project2, status2) -> project2.setStatus(ProjectStatus.getProjectStatus(status2)));
    }

    public static void sumOfTaxes(ITCompany company) {
        ITCompanyFunctions.sumOfTaxes(company, (company1, i) -> company1.getTaxes().get(i).getPrice());
    }

    public static void entertainmentPlanning(ITCompany company, String name, Address address) {
        ITCompanyFunctions.entertainmentPlanning(company, name, address,
                (company1, name1, address1) -> {
                    company1.getEntertainments().add(new Entertainment(name1, address1));
                });
    }

    @Important(value = "Booking Company Service")
    public static void bookService(Customer customer, ITCompany company, String projectName) throws BookingException {
        BookingService.bookService(customer, company, projectName, e -> e.getEmployees().size() == 2);
    }

    public static void getEmployeeResume(Employee employee) {
        BookingService.employeeResume(employee);
    }

    public Object getsmth(Function<Company, Object> smth) {
        return smth.apply(this);
    }

    public void salaryCalculator() {
        ITCompanyFunctions.salaryCalculator(employees, (employee) ->
                System.out.println("salary of " + employee + " is-" + employee.getRating().getRate() * employee.getStatus().getBonus() * 200 + " lari"));
    }

    @Important(value = "CanCel Booked Service")
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

    public Room<Developer> getDevRoom() {
        return devRoom;
    }

    public void setDevRoom(Room<Developer> devRoom) {
        this.devRoom = devRoom;
    }

    public Room<Tester> getTesterRoom() {
        return testerRoom;
    }

    public void setTesterRoom(Room<Tester> testerRoom) {
        this.testerRoom = testerRoom;
    }

    public Order<Entertainment> getOrderEntertainment() {
        return orderEntertainment;
    }

    public void setOrderEntertainment(Order<Entertainment> orderEntertainment) {
        this.orderEntertainment = orderEntertainment;
    }

    public Order<Equipment> getEquipmentOrder() {
        return equipmentOrder;
    }

    public void setEquipmentOrder(Order<Equipment> equipmentOrder) {
        this.equipmentOrder = equipmentOrder;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
