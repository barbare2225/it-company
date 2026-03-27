package company.partners;

import superclasses.Partner;

public class CompanyPartner extends Partner {

    protected int yearOfBirth;
    private String type;

    public CompanyPartner(String name, int yearOfBirth, String type) {
        super(name, "company");
        this.yearOfBirth = yearOfBirth;
        this.type = type;
    }

    // getters and setters
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }
}
