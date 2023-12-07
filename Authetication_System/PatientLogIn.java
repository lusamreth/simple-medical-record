package Authetication_System;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PatientLogIn {

    static ArrayList<Patient> userList = new ArrayList<Patient>();

    public static void getUserList() {
        String filePath = "D://Java_Folder//CamTech//User//Database//patientInfo.txt";

        try {
            // Create a FileReader
            FileReader fileReader = new FileReader(filePath);
            // Wrap the FileReader in a BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line as needed
                // System.out.println(line);
                String[] parts = line.split("/");

                // Check if the array has the expected length before accessing its elements
                if (parts.length == 2) {
                    Patient tmp = new Patient(parts[0], parts[1]);
                    userList.add(tmp);
                } else {
                    // Handle the case where the line doesn't have the expected format
                    System.err.println("Invalid line format: " + line);
                }
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be read
            e.printStackTrace();
        }
    }

    public static boolean VerifyUserName(String name) {

        getUserList();

        boolean exist = false;
        for (Patient i : userList) {
            // System.out.println(i.getName());
            if (i.getName().equals(name)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Patient exist please pick different name");
            return true;
        }

        return false;
    }

    public static void loginUser(Patient loginUser) {

        getUserList();

        boolean exist = false;
        for (Patient i : userList) {
            if (i.equals(loginUser)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Patient exist");
        } else {
            System.out.println("Patient doesn't exist");
        }
    }
}
