package company;

import interfaces.IAddress;

public final class Address implements IAddress {

    private static final int maxAddresses = 1000; // government limit

    private static int totalAddresses = 0;

    // static block
    static {
        System.out.println("=== Address System Loaded ===");
        System.out.println("Government max limit: " + maxAddresses);
    }

    private String street;
    private String City;
    private String country;

    // regular block
    {
        if (totalAddresses >= maxAddresses) {
            System.out.println("limit reached (overflow)");
            totalAddresses++;
        } else {
            totalAddresses++;
            System.out.println("New address registered. Total: " + totalAddresses);
        }
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.City = city;
        this.country = country;
    }

    public static int getRemaining() {
        return maxAddresses - totalAddresses;
    }

    public static int getTotalAddresses() {
        return totalAddresses;
    }

    public static void setTotalAddresses(int totalAddresses) {
        Address.totalAddresses = totalAddresses;
    }

    @Override
    public String mapLink() {
        return "http:maps.com/" + this.street;
    }

    @Override
    public void changeAddress(String street, String country, String city) {
        this.street = street;
        this.City = city;
        this.country = country;
    }

    public int getMaxAddress() {
        return maxAddresses;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
