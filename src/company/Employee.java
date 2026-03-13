package company;

import person.Passport;

public class Employee {

    public String name;
    private Passport passport;
    private String role;
    private boolean working;

    public Employee(String name, String role) {
        this.name = name;
        passport = new Passport();
        this.role = role;
        working = false;
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

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
