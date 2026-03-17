package company;

import superClasses.Employee;

public class BookingService {

    public static void bookService(Customer customer, ITCompany company, String projectName) {
        Team team = ITCompanyFunctions.teamDistribution(company, projectName);
        if (team.getNumberOfEmployees() == 2) {
            Project project = new Project(projectName, customer, team);
            company.addProject(project);
            customer.addProject(project);
            System.out.println(customer.getName() + " booked service for project - " + projectName);
        } else {
            System.out.println(customer.getName() + " couldn't book service for project - " + projectName);
        }
    }

    public static void employeeResume(Employee employee) {
        employee.resume();;
    }
}
