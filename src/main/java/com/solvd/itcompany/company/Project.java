package com.solvd.itcompany.company;

import com.solvd.itcompany.enums.ProjectStatus;
import com.solvd.itcompany.interfaces.Solvable;
import com.solvd.itcompany.interfaces.Trackable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
public class Project implements Solvable, Trackable {

    private static final Logger LOGGER = LogManager.getLogger(Project.class);

    private String name;
    private ProjectStatus projectStatus;
    private Team team;
    private Customer customer;

    public Project(String name, Customer customer, Team team) {
        this.name = name;
        this.team = team;
        this.customer = customer;
        projectStatus = ProjectStatus.IN_QUEUE;
    }

    public Project() {
    }

    @Override
    public void cancel() {
        LOGGER.info("{} cancelled project-{}", customer.getName(), team.getName());
    }

    @Override
    public void getDetails() {
        LOGGER.info("{} booked project:{} with team:{}", customer.getName(), this.getName(), this.getTeam().getName());
    }

    @Override
    public void solve() {
        LOGGER.info("Project can be solved");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProjectStatus getStatus() {
        return projectStatus;
    }

    public void setStatus(ProjectStatus status) {
        this.projectStatus = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}