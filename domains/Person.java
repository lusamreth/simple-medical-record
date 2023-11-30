package Medical_Record;

import java.lang.String;
import java.util.Date;

public abstract class Person {
    private String fullname;
    private String firstname;
    private String lastname;
    private String sex;
    private Date dateofbirth;
    private Address address;
    private String[] phoneNumber;

    public Person(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
            Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.dateofbirth = dateofbirth;
        this.phoneNumber = phoneNumber;
        this.address = address;

    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
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

    public void displayPhoneNumber() {
        String formattedPhoneNumber = String.join(", ", phoneNumber);
        // for (int i = 0; i < phoneNumber.length; i++) {
        // System.out.print(phoneNumber[i] + " ");
        // }
        return formattedPhoneNumber;
    }

    // @Override
    public abstract void displayInformation();

}
