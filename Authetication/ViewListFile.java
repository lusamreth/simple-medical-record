package Authetication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewListFile {

    // View Patiet Data
    public static void viewPatientsFile(String filePath) {
        System.out.println("List of Patients:");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] patientData = line.split("/");
                String name = patientData[0];
                String password = patientData[1];
                String emer_call = patientData[2];
                String phone_call = patientData[3];

                Patient patient = new Patient(name, password, emer_call, phone_call);
                System.out.println("Name: " + patient.getUsername());
                System.out.println("Password: " + patient.getPassword());
                System.out.println("Emergency PhoneNumber: " + patient.getEmer_call());
                System.out.println("Personal PhoneNumber: " + patient.getPhone_call());
                System.out.println("----------------------------");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // View Doctor Data
    public static void viewDoctorFile(String filePath) {
        System.out.println("List of Docotr:");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] doctorData = line.split("/");
                String name = doctorData[0];
                String password = doctorData[1];
                String email = doctorData[2];
                String phonenumber = doctorData[3];
                String description = doctorData[4];

                Doctor doctor = new Doctor(name, password, email, phonenumber, description);
                System.out.println("Name: " + doctor.getUsername());
                System.out.println("Password: " + doctor.getPassword());
                System.out.println("Email: " + doctor.getEmail());
                System.out.println("PhoneNumber: " + doctor.getPhoneNumber());
                System.out.println("Description: " + doctor.getDescription());
                System.out.println("----------------------------");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // View Doctor Data
    public static void viewReceptionistFile(String filePath) {
        System.out.println("List of Docotr:");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] recepData = line.split("/");
                String name = recepData[0];
                String password = recepData[1];
                String email = recepData[2];
                String phonenumber = recepData[3];

                Receptionist receptionist = new Receptionist(name, password, email, phonenumber);
                System.out.println("Name: " + receptionist.getUsername());
                System.out.println("Password: " + receptionist.getPassword());
                System.out.println("Email: " + receptionist.getEmail());
                System.out.println("PhoneNumber: " + receptionist.getPhoneNumber());
                System.out.println("----------------------------");
            }
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
