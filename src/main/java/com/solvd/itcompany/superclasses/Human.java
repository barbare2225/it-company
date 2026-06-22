package com.solvd.itcompany.superclasses;

import com.solvd.itcompany.exceptions.EmptyNameException;
import com.solvd.itcompany.exceptions.InvalidAgeException;
import com.solvd.itcompany.passport.Passport;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Human {

    private String name;
    private int age;
    private Passport passport;

    public Human(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new EmptyNameException("Name cannot be empty");
        }
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative");
        }

        this.age = age;
        this.name = name;
        passport = new Passport();
    }

    public Human() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
