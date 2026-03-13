package company;

public class Project {

    private String name;
    private String status; // in_progress, in_queue, Done
    private Team team;
    private Customer customer;

    public Project(String name, Customer customer, Team team) {
        this.name = name;
        this.team = team;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}