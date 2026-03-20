package company;

import interfaces.Trackable;

public class Entertainment implements Trackable {

    private String name;
    private String location;

    Entertainment(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public void cancel() {
        System.out.println("Booking Cancelled");
    }

    @Override
    public void getDetails() {
        System.out.println("entertainment booking Details: name-" + name + " location-" + location);
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
