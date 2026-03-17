package superClasses;

import java.util.Objects;

public class Equipment {

    private String name;
    private String type; // electric, mechanical etc.

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(name, equipment.name) && Objects.equals(type, equipment.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 59 * result;
        return result;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
