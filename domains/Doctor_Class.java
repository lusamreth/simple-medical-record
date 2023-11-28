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

}
