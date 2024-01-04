
package simple.medical.record.domains;

import simple.medical.record.domains.meta.PersonInterface;
import simple.medical.record.utils.UniqueIdGenerator;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Date;
import java.util.Enumeration;
// Doctor.getFirstname
// Doctor.personInfo.getFirstname

public class Doctor extends PersonInterface {
    private String doctorID;
    private String email;
    private String specialty;
    private String qualification;
    private String medRecidency;
    private String description;
    private Person personInfo;

    public Doctor(
            Person personInfo,
            String specialty, String qualification,
            String medRecidency, String description) {

        // super(personInfo.getFirstname(), personInfo.getLastname(),
        // personInfo.getSex(), personInfo.getDateofbirth(),
        // personInfo.getPhoneNumber(), personInfo.getAddress(),
        // personInfo.getPassword());

        // Use class composition
        // anynomous inner class
        // explain protected, public , private
        //
        this.doctorID = UniqueIdGenerator.genId();
        this.specialty = specialty;
        this.qualification = qualification;
        this.medRecidency = medRecidency;
        this.description = description;
        this.personInfo = personInfo;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public Person getPersonInfo() {
        return this.personInfo;
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
        Person personInfo = this.getPersonInfo();
        System.out.println("Doctor General Information: ");
        System.out.println("1. DoctorID: " + getDoctorID() +
                "2. Name: " + personInfo.getFirstname() + " " + personInfo.getLastname() +
                "3. Sex: " + personInfo.getSex() + "\n" +
                "4. Age: " + personInfo.calculateAge() + "\n" +
                "5. Address: " + personInfo.getAddress().toString() + "\n" +
                "6. Phone Number: " + personInfo.getPhoneNumber() + "\n" +
                "7. Emergency Number: " + personInfo.getLastname() + "\n" +
                "8. Email: " + personInfo.getEmail() + "\n");

        System.out.println("Doctor Specialize Information");
        Dictionary<String, String> doctorInfoList = new Hashtable<String, String>();

        doctorInfoList.put("Medical Recidency", this.getMedRecidency());
        doctorInfoList.put("Description", this.getDescription());
        doctorInfoList.put("Specialty", this.getSpecialty());
        doctorInfoList.put("Qualification", this.getQualification());

        Enumeration<String> keys = doctorInfoList.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + " " + doctorInfoList.get(key));
        }

    }

}
