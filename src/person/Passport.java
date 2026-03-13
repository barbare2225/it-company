package person;

import java.time.LocalDate;

public class Passport {

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

