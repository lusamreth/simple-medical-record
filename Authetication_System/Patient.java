package Authetication_System;

public class Patient extends Person {
    private String emer_call;
    private String phone_call;

    public Patient(String name, String password, String emer_call, String phone_call) {
        super(name, password);
        this.emer_call = emer_call;
        this.phone_call = phone_call;
    }

    public String getEmer_call() {
        return emer_call;
    }

    public String getPhone_call() {
        return phone_call;
    }

    @Override
    public String toString() {
        String tmp = "Patient is created \n"
                + "The name is: " + this.name
                + "\nThe password is: " + this.password
                + "\nThe Emergency PhoneNumber is: " + this.emer_call
                + "\nThe Personal PhoneNumber is: " + this.phone_call;

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
