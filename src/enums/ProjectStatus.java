package enums;

public enum ProjectStatus {

    IN_PROGRESS("in progress"),
    IN_QUEUE("in queue"),
    DONE("done");

    static {
        System.out.println("=== ProjectStatus enum loaded ===");
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
