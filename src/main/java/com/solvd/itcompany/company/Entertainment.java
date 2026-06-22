package com.solvd.itcompany.company;

import com.solvd.itcompany.interfaces.Trackable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
public class Entertainment implements Trackable {

    private static final Logger LOGGER = LogManager.getLogger(Entertainment.class);

    private String name;
    private Address address;

    public Entertainment(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Entertainment() {
    }

    @Override
    public void cancel() {
        LOGGER.info("Entertainment-{} got Cancelled", name);
    }

    @Override
    public void getDetails() {
        LOGGER.info("entertainment booking Details: name-{} location-{},{},{}", name, address.getCountry(), address.getCity(), address.getStreet());
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
