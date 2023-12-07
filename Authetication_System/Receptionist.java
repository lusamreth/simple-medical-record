package Authetication_System;

public class Receptionist {
    private String name;
    private String password;

    public Receptionist(String name, String password) {
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
