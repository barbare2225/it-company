package com.solvd.itcompany.superclasses;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.solvd.itcompany.company.equipment.ElectronicDevice;
import com.solvd.itcompany.company.equipment.MechanicalDevice;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MechanicalDevice.class, name = "mechanicalDevice"),
        @JsonSubTypes.Type(value = ElectronicDevice.class, name = "electronicDevice")
})
public class Equipment {

    private String name;
    private String type; // electric, mechanical etc.

    public Equipment(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Equipment() {
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(name, equipment.name) && Objects.equals(type, equipment.type);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 59 * result;
        return result;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
