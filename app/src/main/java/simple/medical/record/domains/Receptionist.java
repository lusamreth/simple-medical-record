package simple.medical.record.domains;

import java.util.Date;

public class Receptionist extends Person {
    private String receptionistID;

    public Receptionist(String firstname, String lastname, String email, String sex, Date dateofbirth,
            String[] phoneNumber,
            Address address, String receptionistID) {
        super(firstname, lastname, sex, email, dateofbirth, phoneNumber, address, "");

        this.receptionistID = receptionistID;
    }

    public String getReceptionistID() {
        return receptionistID;
    }

    public void setReceptionistID(String receptionistID) {
        this.receptionistID = receptionistID;
    }

    public void displayInformation() {
        System.out.println("Receptionist Information");
        System.out.println("1. ReceptionistID: " + getReceptionistID() +
                "2. Name: " + getFirstname() + " " + getLastname() +
                "3. Sex: " + getSex() + "\n" +
                "4. Age: " + calculateAge() + "\n" +
                "5. Address: " + getAddress() + "\n" +
                "6. Phone Number: " + displayPhoneNumber() + "\n");
    }

}
