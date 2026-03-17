package company;

import Passport.Passport;
import superClasses.Human;

public class Customer extends Human {

    private Project project;

    public Customer(String name) {
        super(name);
    }

    @Override
    public void resume() {
        System.out.println("name is " + super.name + " I'm a customer");
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
