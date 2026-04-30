package enums;

public enum CompanyType {

    IT("it company"),
    GOVERNMENT("government company"),
    PRIVATE("private company"),
    OTHER("this type is not in types category");

    static {
        System.out.println("=== CompanyType enum loaded ===");
    }

    private final String value;

    CompanyType(String value) {
        this.value = value;
    }

    public static CompanyType getByCompanyTypeStatus(String status) {
        for (CompanyType value : values()) {
            if (value.getValue().equals(status)) {
                return value;
            }
        }
        throw new RuntimeException("CompanyType with name '%s' cannot be found".formatted(status));
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return this.name() + " (" + value + ")";
    }

}
