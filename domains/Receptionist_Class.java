package Medical_Record;

import java.util.Date;

public class Receptionist extends Person {
    private String receptionistID;

    public Receptionist(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
            Address address, String receptionistID) {
        super(firstname, lastname, sex, dateofbirth, phoneNumber, address);
        this.receptionistID = receptionistID;
    }

    public String getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }

    @Override
    public String toString() {
        return "Receptionist [receptionistID=" + receptionistID + "]";
    }

}
