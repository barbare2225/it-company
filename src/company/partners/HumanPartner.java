package company.partners;

import Passport.Passport;
import superClasses.Partner;

public class HumanPartner extends Partner {

    private Passport passport;

    public HumanPartner(String name) {
        super(name, "human");
        passport = new Passport();
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
