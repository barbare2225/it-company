package company;

import exceptions.BookingException;
import interfaces.Trackable;
import superclasses.employee.Employee;

public class BookingService {

    public static void bookService(Customer customer, ITCompany company, String projectName) throws BookingException {
        Team team = ITCompanyFunctions.teamDistribution(company, projectName);
        if (team.getEmployees().size() == 2) {
            Project project = new Project(projectName, customer, team);
            company.getProjects().add(project);
            customer.addProject(project);
            System.out.println(customer.getName() + " booked service for project - " + projectName);
        } else {
            System.out.println(customer.getName() + " couldn't book service for project - " + projectName);
            throw new BookingException("Booking failed");
        }
    }

    public static void employeeResume(Employee employee) {
        employee.resume();
    }

    public void cancelBooking(Trackable trackable) {
        trackable.cancel();
    }

    public void getBookingDetails(Trackable trackable) {
        trackable.getDetails();
    }
}
