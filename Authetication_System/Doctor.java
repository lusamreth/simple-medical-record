package Authetication_System;

public class Doctor {
    private String name;
    private String password;

    public Doctor(String name, String password) {
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
        String tmp = "Doctor is created \n"
                + "The name is: " + this.name
                + "\nThe password is: " + this.password;

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
