package com.solvd.itcompany.company.equipment;

import com.solvd.itcompany.superclasses.Equipment;

public class ElectronicDevice extends Equipment {

    private int numberOfPorts;

    public ElectronicDevice(String name, int numberOfPorts) {
        super(name, "electronic");
        this.numberOfPorts = numberOfPorts;
    }

    // getters and setters
    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }
}
