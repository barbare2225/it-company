package company;

public class Company {

    static private int numberOfCompanies = 0;

    // static field
    static {
        System.out.println("Company Class Loaded");
    }

    private String name;
    private Address[] addresses;
    private Employee[] employees;
    private Entertainment[] entertainments;
    private Equipment[] equipment;
    private Partner[] partners;
    private Problem[] problems;
    private Project[] projects;
    private Tax[] taxes;

    public Company(String name) {
        this.name = name;
        projects = new Project[0];
        employees = new Employee[0];
        partners = new Partner[0];
        addresses = new Address[0];
        taxes = new Tax[0];
        entertainments = new Entertainment[0];
        equipment = new Equipment[0];
        problems = new Problem[0];
        numberOfCompanies++;
    }

    public Company() {
    }

    // static getters and setters
    public static int getNumberOfCompanies() {
        return numberOfCompanies;
    }

    public static void setNumberOfCompanies(int numberOfCompanies) {
        Company.numberOfCompanies = numberOfCompanies;
    }

    // functions
    public static void updateProject(Project project, String status) {
        CompanyFunctions.updateProject(project, status);
    }

    public static void sumOfTaxes(Company company) {
        CompanyFunctions.sumOfTaxes(company);
    }

    public static void entertainmentPlanning(Company company, String name, String location) {
        CompanyFunctions.entertainmentPlanning(company, name, location);
    }

    public static void bookService(Customer customer, Company company, String projectName) {
        BookingService.bookService(customer, company, projectName);
    }

    // adding stuff
    public void addEmployee(Employee employee) {
        Employee[] newEmployees = new Employee[employees.length + 1];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        newEmployees[employees.length] = employee;
        employees = newEmployees;
    }

    public void addProject(Project project) {
        Project[] newProjects = new Project[projects.length + 1];
        System.arraycopy(projects, 0, newProjects, 0, projects.length);
        newProjects[projects.length] = project;
        projects = newProjects;
    }

    public void addTax(Tax tax) {
        Tax[] newTaxes = new Tax[taxes.length + 1];
        System.arraycopy(taxes, 0, newTaxes, 0, taxes.length);
        newTaxes[taxes.length] = tax;
        taxes = newTaxes;
    }

    public void addPartner(Partner partner) {
        Partner[] newPartners = new Partner[partners.length + 1];
        System.arraycopy(partners, 0, newPartners, 0, partners.length);
        newPartners[partners.length] = partner;
        partners = newPartners;
    }

    public void addAddress(Address address) {
        Address[] newAddresses = new Address[addresses.length + 1];
        System.arraycopy(addresses, 0, newAddresses, 0, addresses.length);
        newAddresses[addresses.length] = address;
        addresses = newAddresses;
    }

    public void addEntertainment(String name, String location) {
        Entertainment[] newEntertainments = new Entertainment[entertainments.length + 1];
        System.arraycopy(entertainments, 0, newEntertainments, 0, entertainments.length);
        newEntertainments[entertainments.length] = new Entertainment(name, location);
        entertainments = newEntertainments;
    }

    public void addEquipment(Equipment equipment) {
        Equipment[] newEquipment = new Equipment[this.equipment.length + 1];
        System.arraycopy(this.equipment, 0, newEquipment, 0, this.equipment.length);
        newEquipment[this.equipment.length] = equipment;
        this.equipment = newEquipment;
    }

    public void addProblems(Problem problem) {
        Problem[] newProblems = new Problem[problems.length + 1];
        System.arraycopy(problems, 0, newProblems, 0, problems.length);
        newProblems[problems.length] = problem;
        problems = newProblems;
    }

    // setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Entertainment[] getEntertainments() {
        return entertainments;
    }

    public void setEntertainments(Entertainment[] entertainments) {
        this.entertainments = entertainments;
    }

    public Equipment[] getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment[] equipment) {
        this.equipment = equipment;
    }

    public Partner[] getPartners() {
        return partners;
    }

    public void setPartners(Partner[] partners) {
        this.partners = partners;
    }

    public Problem[] getProblems() {
        return problems;
    }

    public void setProblems(Problem[] problems) {
        this.problems = problems;
    }

    public Project[] getProjects() {
        return projects;
    }

    public void setProjects(Project[] projects) {
        this.projects = projects;
    }

    public Tax[] getTaxes() {
        return taxes;
    }

    public void setTaxes(Tax[] taxes) {
        this.taxes = taxes;
    }
}
