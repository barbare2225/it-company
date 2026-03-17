package superClasses;

import Passport.Passport;

import java.util.Objects;

public abstract class Human {

    public String name;
    private Passport passport;

    public Human(String name) {
        this.name = name;
        passport = new Passport();
    }

    public abstract void resume();

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", passport=" + passport + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 15 * result;
        return result;
    }

    // setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
