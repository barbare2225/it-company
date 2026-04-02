package company;

import interfaces.Solvable;

import java.util.Objects;

public class Problem implements Solvable {

    private String name;
    private String location;

    public Problem(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public void solve() {
        System.out.println("Problem solved");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Problem p)) return false;
        return name.equals(p.name) &&
                location.equals(p.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location);
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
