package com.solvd.itcompany.company.equipment;

import com.solvd.itcompany.superclasses.Equipment;

public class MechanicalDevice extends Equipment {

    private boolean working;

    public MechanicalDevice(String name, boolean working) {
        super(name, "mechanical");
        this.working = working;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
