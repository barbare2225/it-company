package com.solvd.itcompany.company.equipment;

import com.solvd.itcompany.superclasses.Equipment;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class ElectronicDevice extends Equipment {

    private int numberOfPorts;

    public ElectronicDevice(String name, int numberOfPorts) {
        super(name, "electronicDevice");
        this.numberOfPorts = numberOfPorts;
    }

    public ElectronicDevice() {
        super();
    }

    // getters and setters
    public int getNumberOfPorts() {
        return numberOfPorts;
    }

    public void setNumberOfPorts(int numberOfPorts) {
        this.numberOfPorts = numberOfPorts;
    }
}
