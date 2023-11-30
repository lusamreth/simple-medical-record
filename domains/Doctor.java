package Medical_Record;

import java.util.Date;

public class Doctor extends Person {
    private String doctorID;
    private String email;
    private String specialty;
    private String qualification;
    private String medRecidency;
    private String description;

    public Doctor(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
            Address address, String doctorID, String email, String specialty, String qualification,
            String medRecidency, String description) {
        super(firstname, lastname, sex, dateofbirth, phoneNumber, address);
        this.doctorID = doctorID;
        this.email = email;
        this.specialty = specialty;
        this.qualification = qualification;
        this.medRecidency = medRecidency;
        this.description = description;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getMedRecidency() {
        return medRecidency;
    }

    public void setMedRecidency(String medRecidency) {
        this.medRecidency = medRecidency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void displayInformation() {
        System.out.println("Doctor General Information");
        System.out.println("1. PatientID: " + getDoctorID() +
                "2. Name: " + getFirstname() + " " + getLastname() +
                "3. Sex: " + getSex() + "\n" +
                "4. Age: " + calculateAge() + "\n" +
                "5. Address: " + getLastname() + "\n" +
                "6. Phone Number: " + getPhoneNumber() + "\n" +
                "7. Emergency Number: " + getLastname() + "\n" +
                "8. Email: " + getEmail() + "\n");

        System.out.println("Doctor Specialize Information");
        System.out.println("1. PatientID: " + getDoctorID() +
                "2. Name: " + getFirstname() + " " + getLastname() +
                "3. Sex: " + getSex() + "\n" +
                "4. Age: " + calculateAge() + "\n" +
                "5. Address: " + getLastname() + "\n" +
                "6. Phone Number: " + getPhoneNumber() + "\n" +
                "7. Emergency Number: " + getLastname() + "\n" +
                "8. Email: " + getEmail() + "\n");

    }

}
