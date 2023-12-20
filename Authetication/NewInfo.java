package Authetication;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NewInfo {

    // Patient Update Infor
    public static void updatePatientInfo(String filePath, String oldUsername, String oldPassword,
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

    public static void patientInfo(String oldUsername, String oldPassword, String newUsername, String newPassword) {
        String filePath = "Authetication\\Database\\patientInfo.txt"; // Replace with the actual file path
        updatePatientInfo(filePath, oldUsername, oldPassword, newUsername, newPassword);
        System.out.println("Username and password updated successfully!");
    }

    // Doctor Update info
    public static void updateDoctorInfo(String filePath, String oldUsername, String oldPassword,
            String newUsername, String newPassword) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] doctorData = line.split("/");
                String username = doctorData[0];
                String password = doctorData[1];

                if (username.equals(oldUsername) && password.equals(oldPassword)) {
                    username = newUsername;
                    password = newPassword;
                }

                String updatedLine = username + "/" + password + "/" + doctorData[2] + "/" + doctorData[3] + "/"
                        + doctorData[4];
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

    public static void doctorInfo(String oldUsername, String oldPassword, String newUsername, String newPassword) {
        String filePath = "Authetication\\Database\\doctorInfo.txt"; // Replace with the actual file path
        updateDoctorInfo(filePath, oldUsername, oldPassword, newUsername, newPassword);
        System.out.println("Username and password updated successfully!");
    }

    // Receptionist Update Infor
    public static void updateRecepInfo(String filePath, String oldUsername, String oldPassword,
            String newUsername, String newPassword) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] recepData = line.split("/");
                String username = recepData[0];
                String password = recepData[1];

                if (username.equals(oldUsername) && password.equals(oldPassword)) {
                    username = newUsername;
                    password = newPassword;
                }

                String updatedLine = username + "/" + password + "/" + recepData[2] + "/" + recepData[3];
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

    public static void recepInfo(String oldUsername, String oldPassword, String newUsername, String newPassword) {
        String filePath = "Authetication\\Database\\receptionistInfor.txt";
        updateRecepInfo(filePath, oldUsername, oldPassword, newUsername, newPassword);
        System.out.println("Username and password updated successfully!");
    }
}
