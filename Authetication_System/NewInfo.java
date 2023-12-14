package Authetication_System;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewInfo {
    public static void changeUsernameAndPassword(String filePath, String oldUsername, String oldPassword,
            String newUsername, String newPassword) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] patientData = line.split("/");
                String username = patientData[0];
                String password = patientData[1];

                if (username.equals(oldUsername) && password.equals(oldPassword)) {
                    username = newUsername;
                    password = newPassword;
                }

                String updatedLine = username + "/" + password + "/" + patientData[2] + "/" + patientData[3];
                lines.add(updatedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void UpdateInfo(String oldUsername, String oldPassword, String newUsername, String newPassword) {
        String filePath = "Authetication\\Database\\patientInfo.txt"; // Replace with the actual file path
        changeUsernameAndPassword(filePath, oldUsername, oldPassword, newUsername, newPassword);
        System.out.println("Username and password updated successfully!");
    }
}
