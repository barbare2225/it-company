package superClasses;

public class Employee extends Human {

    private String role;
    private boolean isWorking;

    public Employee(String name, String role) {
        super(name);
        this.role = role;
        isWorking = false;
    }

    @Override
    public void resume() {
        System.out.println("name is " + super.name + "Role is " + this.role);
    }

    // getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
}
