/*
 * 1. Register (validate the username before register)
 * 2. login 
 * 
 * save data in text file
 * login, can display information more than username and pasword
 * can change username
 * can change password
 * overriding toString method
 * overriding equal method
 */

package Authetication_System;

import java.util.Scanner;

public class Authenticate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmpName;
        String tmpPassword;
        int choice, type;

        System.out.println("Please choose to Login or Sign Up.");
        System.out.println("1. Register\n2. Login");
        System.out.println("other. Quit");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            // Choose 1 to Sign Up to the System
            case 1:
                System.out.println("Please choose the your role in the System.");
                System.out.println("1. Patient\n2. Doctor\n3. Receptionist");
                System.out.println("other. Quit");
                type = sc.nextInt();
                sc.nextLine();

                switch (type) {
                    // patient Register
                    case 1:
                        do {
                            System.out.print("Input name: ");
                            tmpName = sc.nextLine();
                        } while (PatientLogIn.VerifyUserName(tmpName));
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Register.registerPatient(tmpName, tmpPassword);
                        break;
                    // Doctor Register
                    case 2:
                        do {
                            System.out.print("Input name: ");
                            tmpName = sc.nextLine();
                        } while (DoctorlogIn.VerifyUserName(tmpName));
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Register.registerDoctor(tmpName, tmpPassword);
                        break;

                    // Patient Register
                    case 3:
                        do {
                            System.out.print("Input name: ");
                            tmpName = sc.nextLine();
                        } while (ReceptionistlogIn.VerifyUserName(tmpName));
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Register.registerReceptionist(tmpName, tmpPassword);
                        break;

                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("Please choose the type of account to LogIN.");
                System.out.println("1. Patient\n2. Doctor\n3. Receptionist");
                System.out.println("other. Quit");
                type = sc.nextInt();
                sc.nextLine();

                switch (type) {
                    // Login to patient Account
                    case 1:
                        System.out.print("Input name: ");
                        tmpName = sc.nextLine();
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Patient patient = new Patient(tmpName, tmpPassword);
                        PatientLogIn.loginUser(patient);
                        break;

                    // login to Doctor Account
                    case 2:
                        System.out.print("Input name: ");
                        tmpName = sc.nextLine();
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Doctor doctor = new Doctor(tmpName, tmpPassword);
                        DoctorlogIn.loginUser(doctor);
                        break;

                    // login to receptionist Account
                    case 3:
                        System.out.print("Input name: ");
                        tmpName = sc.nextLine();
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Receptionist receptionist = new Receptionist(tmpName, tmpPassword);
                        ReceptionistlogIn.loginRecep(receptionist);
                        break;

                    default:
                        break;
                }

                break;
            default:
                break;
        }

        sc.close();
    }
}
