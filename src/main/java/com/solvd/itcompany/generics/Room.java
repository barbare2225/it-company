package com.solvd.itcompany.generics;

import com.solvd.itcompany.superclasses.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class Room<T extends Employee> {

    private String name;
    private List<T> stuff;

    public Room(String name) {
        this.name = name;
        this.stuff = new ArrayList<>();
    }

    public void add(T e) {
        stuff.add(e);
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getStuff() {
        return stuff;
    }

    public void setStuff(List<T> stuff) {
        this.stuff = stuff;
    }
}