package company;

public class Team {

    private String name;
    private Employee[] employees;
    private Customer customer;
    private int numberOfEmployees;

    public Team(String name) {
        this.name = name;
        employees = new Employee[2];
        numberOfEmployees = 0;
    }

    // functions
    public void addEmployee(Employee employee) {
        employees[numberOfEmployees++] = employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
