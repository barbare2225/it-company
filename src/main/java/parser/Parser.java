package parser;

import com.solvd.itcompany.company.ITCompany;

import java.io.File;

/**
 * Implementations may use different parsing technologies
 * such as JAXB, Jackson, DOM, SAX, or StAX.
 * populated {@link com.solvd.itcompany.company.ITCompany} object hierarchy.
 *
 * <p>The parser reads company.xml and converts XML elements into Java objects.</p>
 *
 * <p>Example XPath expressions:</p>
 * <ul>
 *     <li>/company/name</li>
 *     <li>/company/employees/employee/passport/expirationDate</li>
 *     <li>/company/projects/project/customer/name</li>
 *     <li>/company/projects/project/team/employees/employee</li>
 *     <li>/company/addresses/address/city</li>
 *     <li>/company/equipments/electronicDevice/numberOfPorts</li>
 * </ul>
 */


public interface Parser {

    ITCompany parse(File file);
}
