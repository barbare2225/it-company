package com.solvd.itcompany.passport;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.itcompany.adapters.LocalDateAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import parser.JacksonParser;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Passport {

    @JsonDeserialize(using = JacksonParser.LocalDateDeserializer.class)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate expirationDate;

    public Passport() {
        expirationDate = LocalDate.now().plusYears(4);
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

