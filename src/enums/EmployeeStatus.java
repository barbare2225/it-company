package enums;

public enum EmployeeStatus {

    IS_WORKING("is working", true, 2),
    IS_NOT_WORKING("is not working", false, 1);

    static {
        System.out.println("=== EmployeeStatus enum loaded ===");
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
