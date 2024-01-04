package simple.medical.record.domains;

import java.lang.String;
import java.util.Date;

import simple.medical.record.utils.UniqueIdGenerator;

public class Person {
    private String userId;
    private String firstname;
    private String lastname;
    private String sex;
    private Date dateofbirth;
    private Address address;
    // private String address;
    private String[] phoneNumber;
    private String password;
    private String email;

    public Person(String firstname, String lastname, String email, String sex, Date dateofbirth, String[] phoneNumber,
            Address address,
            // String address,
            String password) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.sex = sex;
        this.userId = UniqueIdGenerator.genId();
        this.dateofbirth = dateofbirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;

    }

    public String getfullName() {
        return this.firstname + " " + this.lastname;
    }

    public String getUserId() {
        return this.userId;
    }

    public void splitFullName(String fullName) {
        // Split the full name into first name and last name
        String[] names = fullName.split("\\s", 2);

        // Update the fields
        if (names.length > 0) {
            this.firstname = names[0];
        }
        if (names.length > 1) {
            this.lastname = names[1];
        }

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int calculateAge() {
        return MedicalDate.calculateAge(dateofbirth, new Date());
    }

    public Date getDateofbirth() {
        return this.dateofbirth;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public String displayPhoneNumber() {
        String formattedPhoneNumber = String.join(", ", phoneNumber);
        // for (int i = 0; i < phoneNumber.length; i++) {
        // System.out.print(phoneNumber[i] + " ");
        // }
        return formattedPhoneNumber;
    }

}
