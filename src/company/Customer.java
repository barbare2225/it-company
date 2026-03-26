package company;

import superClasses.Human;

public class Customer extends Human {

    private Project project;

    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void resume() {
        System.out.println("name is " + super.getName() +" age-"+ super.getAge()+ " I'm a customer");
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
