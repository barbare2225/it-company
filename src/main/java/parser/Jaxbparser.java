package parser;

import com.solvd.itcompany.company.ITCompany;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

/**
 * Implementations uses JAXB parsing technology.
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
public class Jaxbparser implements Parser {

    @Override
    public ITCompany parse(File file) {

        try {
            JAXBContext context = JAXBContext.newInstance(ITCompany.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (ITCompany) unmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

}
