package company;

import interfaces.Trackable;

public class Entertainment implements Trackable {

    private String name;
    private Address address;

    Entertainment(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void cancel() {
        System.out.println("Enterteinment-" + name + " got Cancelled");
    }

    @Override
    public void getDetails() {
        System.out.println("entertainment booking Details: name-" + name + " location-" + address.getCountry() + "," + address.getCity() + "," + address.getStreet());
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getLocation() {
        return address;
    }

    public void setLocation(Address address) {
        this.address = address;
    }

}
