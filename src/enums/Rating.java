package enums;

public enum Rating {

    SUPER("one of the best", 5),
    GOOD("better than normal", 4),
    MEDIUM("normal", 3),
    NOT_GOOD("doable", 2),
    BAD("doesn't work well", 1),
    NULL("no rating", 5);

    static {
        System.out.println("=== Rating enum loaded ===");
    }

    private final String name;
    private final int rate;

    Rating(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public static Rating getRatingStatus(String name) {
        for (Rating value : values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        throw new RuntimeException("EmployeeStatus with name '%s' cannot be found".formatted(name));
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }

    public String getDescription() {
        return this.name() + " (" + rate + ")";
    }


}
