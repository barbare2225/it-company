package com.solvd.itcompany.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String value) {
        if (value == null) {
            return null;
        }
        return LocalDate.parse(value);
    }

    @Override
    public String marshal(LocalDate value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}