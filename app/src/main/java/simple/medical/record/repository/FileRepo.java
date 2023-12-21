package simple.medical.record.repository;

import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList; // Needed for ArrayList class

// custom file reader object
public class FileRepo {
    private String fileName;

    // tag error if there exception
    public boolean hasException = false;
    // we know first hand that both list contains 200 names each
    private ArrayList<String> loadedContent = new ArrayList<String>();

    // constructor
    public FileRepo(String filename) {
        this.fileName = filename;
    }

    // mutator to identify error
    public void flagError() {
        this.hasException = true;
    }

    // getter to check error
    public boolean isError() {
        return this.hasException;
    }

    public void appendToFile(String[] content) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (int i = 0; i < content.length; i++) {
            String contentLine = content[i];
            writer.write(contentLine);
        }

        writer.close();
    }

    public void writeCSVFile(String[] content) throws IOException {

        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String csvOutputFile = this.convertToCSV(content);
        writer.write(csvOutputFile);
        writer.close();
    }

    // method for reading and loading each line into array list
    public ArrayList<String> read() {
        // file object
        File reader = new File(this.fileName);
        try {
            // pass the file object into scanner for reading
            Scanner myReader = new Scanner(reader);

            // keep reading the file until there is no more line
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // load all the line into ArrayList for later use
                this.loadedContent.add(data);
            }

            myReader.close();
            // add exception in case we found empty path
        } catch (FileNotFoundException e) {

            this.flagError();

            // custom err handling
            System.out.println("Encounter Incorrect File Path!");

        } catch (Exception e) {

            this.flagError();
            // unkown exception handling
            System.out.print("Encounter Unknown Exception...");
            System.out.println(e.toString());

        }

        //
        return this.loadedContent;
    }

    public String escapeSpecialCharacters(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Input data cannot be null");
        }
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String[] fromArrayListToStringList(ArrayList<String> data) {

        String[] str = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            str[i] = data.get(i);
        }
        return str;
    }

}
