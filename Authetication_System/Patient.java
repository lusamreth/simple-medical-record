package Authetication_System;

public class Patient {
    private String name;
    private String password;

    public Patient(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        String tmp = "Patient is created \n"
                + "The name is: " + this.name
                + "\nThe password is: " + this.password;

        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        Patient tmpUser = (Patient) obj;

        if (this.name.equals(tmpUser.name) && this.password.equals(tmpUser.password)) {
            return true;
        }
        return false;
    }

}
