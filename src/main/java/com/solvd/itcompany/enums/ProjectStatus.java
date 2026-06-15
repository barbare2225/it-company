package com.solvd.itcompany.enums;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum ProjectStatus {

    IN_PROGRESS("in progress"),
    IN_QUEUE("in queue"),
    DONE("done");

    private static final Logger LOGGER = LogManager.getLogger(ProjectStatus.class);

    static {
        LOGGER.info("=== ProjectStatus enum loaded ===");
    }

    private final String status;

    ProjectStatus(String status) {
        this.status = status;
    }

    public static ProjectStatus getProjectStatus(String status) {
        for (ProjectStatus projectStatus : ProjectStatus.values()) {
            if (projectStatus.getStatus().equals(status)) {
                return projectStatus;
            }
        }

        throw new RuntimeException("projectStatus with status '%s' cannot be found".formatted(status));
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return this.name() + " (" + getStatus() + ")";
    }
}
