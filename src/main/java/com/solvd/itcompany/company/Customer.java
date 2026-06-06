package com.solvd.itcompany.company;

import com.solvd.itcompany.superclasses.Human;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer extends Human {

    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    private Project project;

    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void resume() {
        LOGGER.info("name is {} age-{} I'm a customer", super.getName() ,super.getAge());
    }

    // functions
    public void addProject(Project project) {
        this.project = project;
    }

    // getters and setters
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
