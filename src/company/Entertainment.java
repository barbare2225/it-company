package company;

public class Entertainment {

    private String name;
    private String location;

    Entertainment(String name, String location) {
        this.name = name;
        this.location = location;
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
