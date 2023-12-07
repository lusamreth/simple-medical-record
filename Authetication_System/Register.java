package Authetication_System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    // Patient Register
    public static void registerPatient(String tmpName, String tmpPassword) {
        Scanner sc = new Scanner(System.in);
        String filePath = "D://Java_Folder//CamTech//User//Database//patientInfo.txt";

        String WritingContent = tmpName + "/" + tmpPassword;

        Patient user1 = new Patient(tmpName, tmpPassword);
        System.out.println(user1);

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }

        sc.close();
    }

    // Doctor Register
    public static void registerDoctor(String tmpName, String tmpPassword) {
        Scanner sc = new Scanner(System.in);
        String filePath = "D://Java_Folder//CamTech//User//Database//doctorInfo.txt";

        String WritingContent = tmpName + "/" + tmpPassword;

        Doctor user1 = new Doctor(tmpName, tmpPassword);
        System.out.println(user1);

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }

        sc.close();
    }

    // Receptionist Register
    public static void registerReceptionist(String tmpName, String tmpPassword) {
        Scanner sc = new Scanner(System.in);
        String filePath = "D://Java_Folder//CamTech//User//Database//receptionistInfor.txt";

        String WritingContent = tmpName + "/" + tmpPassword;

        Receptionist user1 = new Receptionist(tmpName, tmpPassword);
        System.out.println(user1);

        try {
            // Create a FileWriter in append mode by passing true as the second parameter
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Wrap the FileWriter in a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the data to the file
            bufferedWriter.write(WritingContent);
            bufferedWriter.newLine(); // Add a new line for clarity

            // Close the BufferedWriter to ensure all data is flushed to the file
            bufferedWriter.close();

            System.out.println("Data has been appended to the file successfully.");
        } catch (IOException e) {
            // Handle IO exceptions, e.g., if the file cannot be created or written to
            e.printStackTrace();
        }

        sc.close();
    }

}
