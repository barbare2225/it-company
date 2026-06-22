package com.solvd.itcompany.company;

import com.solvd.itcompany.interfaces.IAddress;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
public final class Address implements IAddress {

    private static final Logger LOGGER = LogManager.getLogger(Address.class);

    private static final int maxAddresses = 1000; // government limit

    private static int totalAddresses = 0;

    // static block
    static {
        LOGGER.info("Address System Loaded");
        LOGGER.info("Government max limit: {}", maxAddresses);
    }

    private String street;
    private String city;
    private String country;

    // regular block
    {
        if (totalAddresses >= maxAddresses) {
            LOGGER.info("limit reached (overflow)");
            totalAddresses++;
        } else {
            totalAddresses++;
            LOGGER.info("New address registered. Total: {}", totalAddresses);
        }
    }

    public Address(String street, String city, String country) {
        this.street = street;
        this.city = city;
        this.country = country;
    }

    public Address() {
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
        this.city = city;
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
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
