package Authetication_System;

public class Receptionist extends Person {
    private String email;
    private String PhoneNumber;

    public Receptionist(String name, String password, String email, String phoneNumber) {
        super(name, password);
        this.email = email;
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    @Override
    public String toString() {
        String tmp = "Receptionist is created \n"
                + "The name is: " + this.name
                + "\nThe password is: " + this.password;

        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        Receptionist tmpUser = (Receptionist) obj;

        if (this.name.equals(tmpUser.name) && this.password.equals(tmpUser.password)) {
            return true;
        }
        return false;
    }

}
