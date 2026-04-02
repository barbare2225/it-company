package company.partners;

import superclasses.Partner;

import java.util.Objects;

public class HumanPartner extends Partner {

    private int age;

    public HumanPartner(String name, int age) {
        super(name, "human");
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HumanPartner p)) return false;
        return super.equals(o) && age == p.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
