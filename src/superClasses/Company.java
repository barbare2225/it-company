package superClasses;

public class Company {

    protected String name;
    protected int yearOfBirth;
    private String type;

    public Company(String name, int year, String type) {
        this.name = name;
        this.yearOfBirth = year;
        this.type = type;
    }

    public String getInfo() {
        return "Name: " + this.getName() + ", Year: " + this.getyearOfBirth() + ", Type: " + this.getType();
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", Year: " + this.getyearOfBirth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        if (yearOfBirth != company.yearOfBirth) return false;
        return name.equals(company.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + yearOfBirth;
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getyearOfBirth() {
        return yearOfBirth;
    }

    public void setyearOfBirth(int year) {
        this.yearOfBirth = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
