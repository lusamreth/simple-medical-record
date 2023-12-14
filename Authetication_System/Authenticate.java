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
 * ..........DONE.........
 */

package Authetication_System;

import java.util.Scanner;

public class Authenticate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmpName, tmpPassword;
        String emerCall, phoneCall;
        String email, description, answer;
        String newName, newPassword;
        int choice, type, view;

        System.out.println("Please choose to Login or Sign Up.");
        System.out.println("1. Register\n2. Login\n3. Show List");
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
                        System.out.print("Input Emergency PhoneNumber: ");
                        emerCall = sc.nextLine();
                        System.out.print("Input Personal PhoneNumber: ");
                        phoneCall = sc.nextLine();
                        Register.registerPatient(tmpName, tmpPassword, emerCall, phoneCall);
                        break;
                    // Doctor Register
                    case 2:
                        do {
                            System.out.print("Input name: ");
                            tmpName = sc.nextLine();
                        } while (DoctorlogIn.VerifyUserName(tmpName));
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        System.out.print("Input email: ");
                        email = sc.nextLine();
                        System.out.print("Input phoneNumber: ");
                        phoneCall = sc.nextLine();
                        System.out.print("Input description: ");
                        description = sc.nextLine();
                        Register.registerDoctor(tmpName, tmpPassword, email, phoneCall, description);
                        break;

                    // Patient Register
                    case 3:
                        do {
                            System.out.print("Input name: ");
                            tmpName = sc.nextLine();
                        } while (ReceptionistlogIn.VerifyUserName(tmpName));
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        System.out.print("Input Email: ");
                        email = sc.nextLine();
                        System.out.print("Input PhoneNumber: ");
                        phoneCall = sc.nextLine();
                        Register.registerReceptionist(tmpName, tmpPassword, email, phoneCall);
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
                        Patient patient = new Patient(tmpName, tmpPassword, null, null);
                        PatientLogIn.loginUser(patient);

                        // Update information
                        System.out.print("Do you want to update your information or not? (Y or N)");
                        answer = sc.nextLine();
                        if (answer.equals("Y")) {
                            System.out.print("New Username: ");
                            newName = sc.nextLine();
                            System.out.print("New Username: ");
                            newPassword = sc.nextLine();

                            NewInfo.UpdateInfo(tmpName, tmpPassword, newName, newPassword);

                        } else {
                            System.out.println("Thank you");
                        }
                        break;

                    // login to Doctor Account
                    case 2:
                        System.out.print("Input name: ");
                        tmpName = sc.nextLine();
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Doctor doctor = new Doctor(tmpName, tmpPassword, null, null, null);
                        DoctorlogIn.loginUser(doctor);
                        break;

                    // login to receptionist Account
                    case 3:
                        System.out.print("Input name: ");
                        tmpName = sc.nextLine();
                        System.out.print("Input password: ");
                        tmpPassword = sc.nextLine();
                        Receptionist receptionist = new Receptionist(tmpName, tmpPassword, null, null);
                        ReceptionistlogIn.loginRecep(receptionist);
                        break;

                    default:
                        break;
                }

                break;
            case 3:
                // ASking User to input the specific file they want to get
                System.out.println("Please choose the account type to display on the screen.");
                System.out.println("1. Patient\n2. Doctor\n3. Receptionist");
                System.out.println("other. Quit");
                view = sc.nextInt();
                sc.nextLine();

                switch (view) {
                    case 1:
                        ViewListFile.viewPatientsFile("Authetication\\Database\\patientInfo.txt");
                        break;

                    case 2:
                        ViewListFile.viewDoctorFile("Authetication\\Database\\doctorInfo.txt");
                        break;

                    case 3:
                        ViewListFile.viewPatientsFile("Authetication\\Database\\receptionistInfor.txt");
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
