package company.employeeRoles;

import superClasses.employee.Employee;

public class Developer extends Employee {

    private final int succesfullProjects;

    public Developer(String name, int age, int succesfullProjects) {
        super(name, age, "Developer");
        this.succesfullProjects = succesfullProjects;
    }

    @Override
    public void resume() {
        System.out.println("resumeDeveloper: name-" + super.getName() + " age-" + super.getAge() + " role-" + super.getRole() + " succesfullProjects-" + this.succesfullProjects);
    }
}
