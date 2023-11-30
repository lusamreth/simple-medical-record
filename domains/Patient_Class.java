package Medical_Record;

import java.util.Date;

public class Patient extends Person {
    private String patientID;
    private String emer_call;
    private String last_visited;

    public Patient(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
            Address address, String patientID, String emer_call, String last_visited) {
        super(firstname, lastname, sex, dateofbirth, phoneNumber, address);
        this.patientID = patientID;
        this.emer_call = emer_call;
        this.last_visited = last_visited;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getEmer_call() {
        return emer_call;
    }

    public void setEmer_call(String emer_call) {
        this.emer_call = emer_call;
    }

    public String getLast_visited() {
        return last_visited;
    }

    public void setLast_visited(String last_visited) {
        this.last_visited = last_visited;
    }

    @Override
    public void displayInformation() {
        System.out.println("Patient Information");
        System.out.println("1. PatientID: " + getPatientID() +
                "2. Name: " + getFirstname() + " " + getLastname() +
                "3. Sex: " + getSex() + "\n" +
                "4. Age: " + calculateAge() + "\n" +
                "5. Address: " + getLastname() + "\n" +
                "6. Phone Number: " + getPhoneNumber() + "\n" +
                "7. Emergency Number: " + getEmer_call() + "\n" +
                "8. Last Visited: " + getLast_visited() + "\n");
    }

}
