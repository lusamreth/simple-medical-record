package Authetication;

public class Doctor extends Person {
    private String email;
    private String phoneNumber;
    private String description;

    public Doctor(String name, String password, String email, String phoneNumber, String description) {
        super(name, password);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String tmp = "----------------\n\n" + "Doctor is created \n"
                + "The name is: " + this.name
                + "\nThe password is: " + this.password
                + "\nThe email is: " + this.email
                + "\nThe phone number is: " + this.phoneNumber
                + "\nThe description is: " + this.description;

        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        Doctor tmpUser = (Doctor) obj;

        if (this.name.equals(tmpUser.name) && this.password.equals(tmpUser.password)) {
            return true;
        }
        return false;
    }

}
