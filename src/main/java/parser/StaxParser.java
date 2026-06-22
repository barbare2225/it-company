package parser;

import com.solvd.itcompany.company.*;
import com.solvd.itcompany.company.employeeRoles.Developer;
import com.solvd.itcompany.company.employeeRoles.Recruiter;
import com.solvd.itcompany.company.employeeRoles.Tester;
import com.solvd.itcompany.company.equipment.ElectronicDevice;
import com.solvd.itcompany.company.equipment.MechanicalDevice;
import com.solvd.itcompany.enums.Department;
import com.solvd.itcompany.enums.EmployeeStatus;
import com.solvd.itcompany.enums.ProjectStatus;
import com.solvd.itcompany.enums.Rating;
import com.solvd.itcompany.passport.Passport;
import com.solvd.itcompany.superclasses.Equipment;
import com.solvd.itcompany.superclasses.employee.Employee;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class StaxParser implements Parser {

    @Override
    public ITCompany parse(File file) {

        ITCompany company = new ITCompany();
        company.setEmployees(new HashSet<>());
        company.setProjects(new ArrayList<>());
        company.setEntertainments(new ArrayList<>());
        company.setAddresses(new ArrayList<>());
        company.setEquipment(new ArrayList<>());

        XMLInputFactory factory = XMLInputFactory.newInstance();

        Employee currentEmployee = null;
        Passport currentPassport = null;
        Project currentProject = null;
        Customer currentCustomer = null;
        Team currentTeam = null;
        Entertainment currentEntertainment = null;
        Address currentAddress = null;
        Equipment currentEquipment = null;

        try (FileInputStream fis = new FileInputStream(file)) {

            XMLStreamReader reader = factory.createXMLStreamReader(fis);

            while (reader.hasNext()) {
                int event = reader.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    String tag = reader.getLocalName();

                    switch (tag) {
                        case "company":
                            break;

                        case "developer":
                            currentEmployee = new Developer();
                            if (currentTeam != null) {
                                currentTeam.getEmployees().add(currentEmployee);
                            } else company.getEmployees().add(currentEmployee);
                            break;

                        case "tester":
                            currentEmployee = new Tester();
                            if (currentTeam != null) {
                                currentTeam.getEmployees().add(currentEmployee);
                            } else company.getEmployees().add(currentEmployee);
                            break;

                        case "recruiter":
                            currentEmployee = new Recruiter();
                            if (currentTeam != null) {
                                currentTeam.getEmployees().add(currentEmployee);
                            } else company.getEmployees().add(currentEmployee);
                            break;

                        case "project":
                            currentProject = new Project();
                            company.getProjects().add(currentProject);
                            break;

                        case "entertainment":
                            currentEntertainment = new Entertainment();
                            company.getEntertainments().add(currentEntertainment);
                            break;

                        case "address":
                            currentAddress = new Address();
                            if (currentEntertainment != null) {
                                currentEntertainment.setAddress(currentAddress);
                            } else company.getAddresses().add(currentAddress);
                            break;

                        case "mechanicalDevice":
                            currentEquipment = new MechanicalDevice();
                            company.getEquipment().add(currentEquipment);
                            break;

                        case "electronicDevice":
                            currentEquipment = new ElectronicDevice();
                            company.getEquipment().add(currentEquipment);
                            break;

                        case "passport":
                            if (currentEmployee != null) {
                                currentPassport = new Passport();
                                currentEmployee.setPassport(currentPassport);
                            } else if (currentCustomer != null) {
                                currentPassport = new Passport();
                                currentCustomer.setPassport(currentPassport);
                            }
                            break;

                        case "customer":
                            if (currentProject != null) {
                                currentCustomer = new Customer();
                                currentProject.setCustomer(currentCustomer);
                            }
                            break;

                        case "team":
                            if (currentProject != null) {
                                currentTeam = new Team();
                                currentTeam.setEmployees(new HashSet<>());
                                currentProject.setTeam(currentTeam);
                            }
                            break;

                        case "name":
                            if (currentEmployee != null) {
                                currentEmployee.setName(reader.getElementText());
                            } else if (currentCustomer != null) {
                                currentCustomer.setName(reader.getElementText());
                            } else if (currentTeam != null) {
                                currentTeam.setName(reader.getElementText());
                            } else if (currentProject != null) {
                                currentProject.setName(reader.getElementText());
                            } else if (currentEntertainment != null) {
                                currentEntertainment.setName(reader.getElementText());
                            } else if (currentEquipment != null) {
                                currentEquipment.setName(reader.getElementText());
                            } else {
                                company.setName(reader.getElementText());
                            }
                            break;

                        case "age":
                            if (currentEmployee != null) {
                                currentEmployee.setAge(Integer.parseInt(reader.getElementText()));
                            } else if (currentCustomer != null) {
                                currentCustomer.setAge(Integer.parseInt(reader.getElementText()));
                            }
                            break;

                        case "role":
                            if (currentEmployee != null) {
                                currentEmployee.setRole(reader.getElementText());
                            }
                            break;

                        case "department":
                            if (currentEmployee != null) {
                                currentEmployee.setDepartment(Department.valueOf(reader.getElementText()));
                            }
                            break;

                        case "successfulProjects":
                            if (currentEmployee instanceof Developer developer) {
                                developer.setSuccessfulProjects(Integer.parseInt(reader.getElementText()));
                            }
                            break;

                        case "rating":
                            if (currentEmployee != null) {
                                currentEmployee.setRating(Rating.valueOf(reader.getElementText()));
                            }
                            break;

                        case "status":
                            if (currentEmployee != null) {
                                currentEmployee.setStatus(EmployeeStatus.valueOf(reader.getElementText()));
                            } else if (currentProject != null) {
                                currentProject.setStatus(ProjectStatus.valueOf(reader.getElementText()));
                            }
                            break;

                        case "expirationDate":
                            if (currentPassport != null) {
                                currentPassport.setExpirationDate(LocalDate.parse(reader.getElementText()));
                            }
                            break;

                        case "street":
                            if (currentAddress != null) {
                                currentAddress.setStreet(reader.getElementText());
                            }
                            break;

                        case "city":
                            if (currentAddress != null) {
                                currentAddress.setCity(reader.getElementText());
                            }
                            break;

                        case "country":
                            if (currentAddress != null) {
                                currentAddress.setCountry(reader.getElementText());
                            }
                            break;

                        case "type":
                            if (currentEquipment != null) {
                                currentEquipment.setType(reader.getElementText());
                            }
                            break;

                        case "working":
                            if (currentEquipment instanceof MechanicalDevice mechanicalDevice) {
                                mechanicalDevice.setWorking(Boolean.parseBoolean(reader.getElementText()));
                            }
                            break;
                        case "numberOfPorts":
                            if (currentEquipment instanceof ElectronicDevice electronicDevice) {
                                electronicDevice.setNumberOfPorts(Integer.parseInt(reader.getElementText()));
                            }
                            break;
                    }
                }

                if (event == XMLStreamConstants.END_ELEMENT) {
                    String tag = reader.getLocalName();
                    switch (tag) {
                        case "developer":
                        case "tester":
                        case "recruiter":
                            currentEmployee = null;
                            break;
                        case "project":
                            currentProject = null;
                            break;
                        case "passport":
                            currentPassport = null;
                            break;
                        case "team":
                            currentTeam = null;
                            break;
                        case "customer":
                            currentCustomer = null;
                            break;
                        case "entertainment":
                            currentEntertainment = null;
                            break;
                        case "address":
                            currentAddress = null;
                            break;
                        case "electronicDevice":
                        case "mechanicalDevice":
                            currentEquipment = null;
                            break;
                    }
                }
            }
            reader.close();

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return company;
    }

}