package company;

public class BookingService {

    public static void bookService(Customer customer, Company company, String projectName) {
        Team team = CompanyFunctions.teamDistribution(company, projectName);
        if (team.getNumberOfEmployees() == 2) {
            Project project = new Project(projectName, customer, team);
            company.addProject(project);
            customer.addProject(project);
            System.out.println(customer.getName() + " booked service for project - " + projectName);
        } else {
            System.out.println(customer.getName() + " couldn't book service for project - " + projectName);
        }
    }
}
