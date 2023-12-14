package Authetication_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DoctorlogIn {
    static ArrayList<Doctor> docList = new ArrayList<Doctor>();

    public static void getUserList() {
        String filePath = "Authetication\\Database\\doctorInfo.txt";

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
                if (parts.length == 5) {
                    Doctor tmp = new Doctor(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    docList.add(tmp);
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
        for (Doctor i : docList) {
            // System.out.println(i.getName());
            if (i.getUsername().equals(name)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Doctor exist please pick different name");
            return true;
        }

        return false;
    }

    public static void loginUser(Doctor loginUser) {

        getUserList();

        boolean exist = false;
        for (Doctor i : docList) {
            if (i.equals(loginUser)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Doctor exist");
        } else {
            System.out.println("Doctor doesn't exist");
        }
    }

}
