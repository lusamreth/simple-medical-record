package Medical_Record;
import java.util.Arrays;
import java.util.Date;

public class Person_Class {
    private String fullname;
    private String firstname;
    private String lastname;
    private String sex;
    private Date dateofbirth;
    private Address_Class address;
    private String[] phoneNumber;
    
    public Person_Class(String firstname, String lastname, String sex, Date dateofbirth,String[] phoneNumber, Address_Class address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.dateofbirth = dateofbirth;
        this.phoneNumber= phoneNumber;
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

    public Address_Class getAddress() {
        return address;
    }

    public void setAddress(Address_Class address) {
        this.address = address;
    }

    public String[] getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String[] phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int calculateAge() {
        return Date_Class.calculateAge(dateofbirth, new Date());
    }

    @Override
    public String toString() {
        return "Person_Class [fullname=" + fullname + ", firstname=" + firstname + ", lastname=" + lastname + ", sex="
                + sex + ", dateofbirth=" + dateofbirth + ", address=" + address + ", phoneNumber="
                + Arrays.toString(phoneNumber) + "]";
    }

    
}


