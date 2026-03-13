package company;

public class Equipment {

    private String name;
    private String type; // electric, mechanical etc.

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
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
