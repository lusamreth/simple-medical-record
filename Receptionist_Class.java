package Medical_Record;

import java.util.Date;

public class Receptionist_Class extends Person_Class{
    private String receptionistID;

    public Receptionist_Class(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
            Address_Class address, String receptionistID) {
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
        return "Receptionist_Class [receptionistID=" + receptionistID + "]";
    }

    
    
}
