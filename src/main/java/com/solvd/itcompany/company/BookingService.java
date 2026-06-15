package com.solvd.itcompany.company;

import com.solvd.itcompany.exceptions.BookingException;
import com.solvd.itcompany.interfaces.Trackable;
import com.solvd.itcompany.superclasses.employee.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Predicate;

public class BookingService {

    private static final Logger LOGGER = LogManager.getLogger(BookingService.class);

    public static void bookService(Customer customer, ITCompany company, String projectName, Predicate<Team> teamIsFull) throws BookingException {
        Team team = ITCompanyFunctions.teamDistribution(company, projectName);
        if (teamIsFull.test(team)) { // team members are 2
            Project project = new Project(projectName, customer, team);
            company.getProjects().add(project);
            customer.addProject(project);
            LOGGER.info("{} booked service for project - {}", customer.getName(), projectName);
        } else {
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
