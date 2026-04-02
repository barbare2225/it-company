package company.partners;

import superclasses.Partner;

import java.util.Objects;

public class CompanyPartner extends Partner {

    private int yearOfBirth;

    public CompanyPartner(String name, int yearOfBirth) {
        super(name, "company");
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyPartner p)) return false;
        return super.equals(o) && yearOfBirth == p.yearOfBirth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), yearOfBirth);
    }

    // getters and setters
    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
