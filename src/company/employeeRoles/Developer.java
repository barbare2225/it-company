package company.employeeRoles;

import superClasses.Employee;

public class Developer extends Employee {

    private int succesfullProjects;

    public Developer(String name, int succesfullProjects) {
        super(name, "Developer");
        this.succesfullProjects = succesfullProjects;
    }

    @Override
    public void resume() {
        System.out.println("resumeDeveloper: name-" + super.name + " role-" + super.getRole() + " succesfullProjects-" + this.succesfullProjects);
    }
}
