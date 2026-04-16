package company;

import enums.ProjectStatus;
import interfaces.Solvable;
import interfaces.Trackable;

public class Project implements Solvable, Trackable {

    private String name;
    private ProjectStatus status;
    private Team team;
    private Customer customer;

    public Project(String name, Customer customer, Team team) {
        this.name = name;
        this.team = team;
        this.customer = customer;
        status = ProjectStatus.IN_QUEUE;
    }

    @Override
    public void cancel() {
        System.out.println(customer.getName() + " cancelled project-" + team.getName());
    }

    @Override
    public void getDetails() {
        System.out.println(customer.getName() + " booked project:" + this.getName() +
                " with team:" + this.getTeam().getName());
    }

    @Override
    public void solve() {
        System.out.println("Project can be solved");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
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