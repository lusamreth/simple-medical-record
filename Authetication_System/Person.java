package Authetication_System;

public class Person {
    protected String name;
    protected String password;

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}