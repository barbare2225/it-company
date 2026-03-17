package company.equipment;

import superClasses.Equipment;

public class MechanicalDevice extends Equipment {

    private boolean isWorking;

    public MechanicalDevice(String name, boolean working) {
        super(name, "mechanical");
        isWorking = working;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
