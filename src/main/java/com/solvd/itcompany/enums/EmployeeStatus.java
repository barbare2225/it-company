package com.solvd.itcompany.enums;

import com.solvd.itcompany.company.employeeRoles.Tester;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum EmployeeStatus {

    IS_WORKING("is working", true, 2),
    IS_NOT_WORKING("is not working", false, 1);

    private static final Logger LOGGER = LogManager.getLogger(EmployeeStatus.class);

    static {
        LOGGER.info("=== EmployeeStatus enum loaded ===");
    }

    private final String value;
    private final boolean active;
    private final int bonus;

    EmployeeStatus(String value, boolean status, int bonus) {
        this.value = value;
        this.active = status;
        this.bonus = bonus;
    }

    public static EmployeeStatus getByEmployeeStatus(String status) {
        for (EmployeeStatus value : values()) {
            if (value.getValue().equals(status)) {
                return value;
            }
        }
        throw new RuntimeException("EmployeeStatus with name '%s' cannot be found".formatted(status));
    }

    public String getValue() {
        return value;
    }

    public boolean isActive() {
        return active;
    }

    public String getDescription() {
        return this.name() + " (" + value + ")";
    }

    public int getBonus() {
        return bonus;
    }
}
