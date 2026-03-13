package company;

import java.time.LocalDate;

public class Problem {

    private String name;
    private LocalDate dateOfDiscovering;
    private String location;

    public Problem(String name, String location) {
        this.name = name;
        this.dateOfDiscovering = LocalDate.now();
        this.location = location;
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
