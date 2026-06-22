package com.solvd.itcompany.company;

import com.solvd.itcompany.superclasses.Human;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer extends Human {

    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    public Customer(String name, int age) {
        super(name, age);
    }

    public Customer() {
        super();
    }

    @Override
    public void resume() {
        LOGGER.info("name is {} age-{} I'm a customer", super.getName(), super.getAge());
    }
}
