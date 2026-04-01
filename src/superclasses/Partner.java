package superclasses;

import java.util.Objects;

public class Partner {

    private String type; // human, company
    private String name;

    public Partner(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner partner)) return false;
        return Objects.equals(name, partner.name) && Objects.equals(type, partner.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }

    // getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
