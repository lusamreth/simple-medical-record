package Authetication;

import java.util.Scanner;
import java.io.*;

public class Register {
    // Patient Register
    public static void registerPatient(String tmpName, String tmpPassword, String tmpCall, String phone_call) {
        Scanner sc = new Scanner(System.in);
        String filePath = "Authetication\\Database\\patientInfo.txt";

        String WritingContent = tmpName + "/" + tmpPassword + "/" + tmpCall + "/" + phone_call;

        Patient user1 = new Patient(tmpName, tmpPassword, tmpCall, phone_call);
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
    public static void registerDoctor(String tmpName, String tmpPassword, String email, String tmpPhone,
            String description) {
        Scanner sc = new Scanner(System.in);
        String filePath = "Authetication\\Database\\doctorInfo.txt";

        String WritingContent = tmpName + "/" + tmpPassword + "/" + email + "/" + tmpPhone + "/" + description;

        Doctor user1 = new Doctor(tmpName, tmpPassword, email, tmpPhone, description);
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
    public static void registerReceptionist(String tmpName, String tmpPassword, String email, String tmpPhone) {
        Scanner sc = new Scanner(System.in);
        String filePath = "Authetication\\Database\\receptionistInfor.txt";

        String WritingContent = tmpName + "/" + tmpPassword + "/" + email + "/" + tmpPhone;

        Receptionist user1 = new Receptionist(tmpName, tmpPassword, email, tmpPhone);
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

    // // Update Credential
    // public static void updateCredentials(String newUsername, String newPassword)
    // {
    // try {
    // // Read the file
    // String filePath =
    // "D://Java_Folder//CamTech//User//Database//receptionistInfor.txt";
    // BufferedReader br = new BufferedReader(new FileReader(filePath));
    // ArrayList<String> lines = new ArrayList<>();
    // String line;

    // while ((line = br.readLine()) != null) {
    // // Identify and modify lines with credentials
    // if (line.startsWith("Username: ")) {
    // line = "Username: " + newUsername;
    // } else if (line.startsWith("Password: ")) {
    // line = "Password: " + newPassword;
    // }

    // // Add the line to the list
    // lines.add(line);
    // }

    // // Close the reader
    // br.close();

    // // Write the modified data back to the file
    // BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

    // for (String modifiedLine : lines) {
    // bw.write(modifiedLine);
    // bw.newLine();
    // }

    // // Close the writer
    // bw.close();

    // System.out.println("Username and password updated successfully.");

    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

}
