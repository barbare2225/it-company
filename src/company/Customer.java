package company;

import person.Passport;

public class Customer {

    private String name;
    private Passport passport;
    private Project project;

    public Customer(String name) {
        this.name = name;
        passport = new Passport();
    }

    // functions
    public void addProject(Project project) {
        this.project = project;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
