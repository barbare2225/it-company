package com.solvd.itcompany.company;

import com.solvd.itcompany.interfaces.Trackable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Entertainment implements Trackable {

    private static final Logger LOGGER = LogManager.getLogger(Entertainment.class);

    private String name;
    private Address address;

    public Entertainment(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public void cancel() {
        LOGGER.info("Entertainment-{} got Cancelled", name );
    }

    @Override
    public void getDetails() {
        LOGGER.info("entertainment booking Details: name-{} location-{},{},{}",name , address.getCountry(), address.getCity(),address.getStreet());
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
