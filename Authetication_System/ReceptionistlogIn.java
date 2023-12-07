package Authetication_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReceptionistlogIn {
    static ArrayList<Receptionist> recepList = new ArrayList<Receptionist>();

    public static void getUserList() {
        String filePath = "D://Java_Folder//CamTech//User//Database//receptionistInfor.txt";

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
                    Receptionist tmp = new Receptionist(parts[0], parts[1]);
                    recepList.add(tmp);
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
        for (Receptionist i : recepList) {
            // System.out.println(i.getName());
            if (i.getName().equals(name)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Receptionist exist please pick different name");
            return true;
        }

        return false;
    }

    public static void loginRecep(Receptionist loginUser) {

        getUserList();

        boolean exist = false;
        for (Receptionist i : recepList) {
            if (i.equals(loginUser)) {
                exist = true;
            }

        }

        if (exist == true) {
            System.out.println("Receptionist exist");
        } else {
            System.out.println("Receptionist doesn't exist");
        }
    }
}
