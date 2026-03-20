package company;

import interfaces.Solvable;

import java.time.LocalDate;

public class Problem implements Solvable {

    private String name;
    private LocalDate dateOfDiscovering;
    private String location;

    public Problem(String name, String location) {
        this.name = name;
        this.dateOfDiscovering = LocalDate.now();
        this.location = location;
    }

    @Override
    public void solve() {
        System.out.println("Problem solved");
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return dateOfDiscovering;
    }

    public void setDate(LocalDate date) {
        this.dateOfDiscovering = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateOfDiscovering() {
        return dateOfDiscovering;
    }

    public void setDateOfDiscovering(LocalDate dateOfDiscovering) {
        this.dateOfDiscovering = dateOfDiscovering;
    }
}
