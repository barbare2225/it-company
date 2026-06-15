package com.solvd.itcompany.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Department {

    HR("human resources", 1),
    IT("IT department", 2),
    FINANCE("finance department", 3),
    SECURITY("security department", 4);

    private static final Logger LOGGER = LogManager.getLogger(Department.class);

    static {
        LOGGER.info("=== Department enum loaded ===");
    }

    private final String value;
    private final int depIndex;

    Department(String value, int depIndex) {
        this.value = value;
        this.depIndex = depIndex;
    }

    public static Department getByCompanyTypeStatus(String status) {
        for (Department value : values()) {
            if (value.getValue().equals(status)) {
                return value;
            }
        }
        throw new RuntimeException("Department with name '%s' cannot be found".formatted(status));
    }

    public String getValue() {
        return value;
    }

    public int getDepIndex() {
        return depIndex;
    }

    public String getDescription() {
        return this.name() + " (" + value + ")";
    }

}
