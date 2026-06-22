package com.solvd.itcompany.company.equipment;

import com.solvd.itcompany.superclasses.Equipment;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MechanicalDevice extends Equipment {

    private boolean working;

    public MechanicalDevice(String name, boolean working) {
        super(name, "mechanicalDevice");
        this.working = working;
    }

    public MechanicalDevice() {
        super();
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
