package company;

import java.math.BigDecimal;

public class Tax {

    private BigDecimal price;
    private String location; // from project/equipment/problem

    public Tax(BigDecimal price, String location) {
        this.price = price;
        this.location = location;
    }

    // getters and setters
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
