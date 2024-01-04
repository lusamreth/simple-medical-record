package simple.medical.record.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.ArrayList; // Needed for ArrayList class
import java.util.Collections;
import java.util.Dictionary;
import java.util.Map;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.opencsv.*;
import org.apache.commons.io.IOUtils;

// import java.io.IO.IOUtils;
interface RepoFileReader {
    public String readContent();

    public String writeContent(String content);
}

abstract public class FileRepo {
    protected String dataEntryPoint;
    protected String fullRepoPath;
    protected boolean hasException = false;

    private File fileObject;

    public void init(String repoPath, String dataEntryPoint) {
        this.dataEntryPoint = dataEntryPoint;
        this.fullRepoPath = repoPath + dataEntryPoint;
        this.fileObject = new File(this.fullRepoPath);
    }

    public FileRepo(String repoPath, String dataEntryPoint) {
        this.init(repoPath, dataEntryPoint);
    }

    public FileRepo(String dataEntryPoint) {
        String DEFAULT_DIR = System.getProperty("user.dir");
        // this.init(repoPath, dataEntryPoint);
        this.dataEntryPoint = dataEntryPoint;
        this.fullRepoPath = DEFAULT_DIR + dataEntryPoint;
        this.fileObject = new File(this.fullRepoPath);
        this.init(DEFAULT_DIR, dataEntryPoint);
    }

    public FileRepo() {
        String DEFAULT_DIR = System.getProperty("user.dir");
        System.out.println("USING DEFAULT REPO DIR " + DEFAULT_DIR);

        this.dataEntryPoint = "db.json";
        this.fullRepoPath = DEFAULT_DIR + dataEntryPoint;
        this.fileObject = new File(this.fullRepoPath);
        this.init(DEFAULT_DIR, "db.json");
    }

    // mutator to identify error
    public void flagError() {
        this.hasException = true;
    }

    // getter to check error
    public boolean isError() {
        return this.hasException;
    }

    protected synchronized String readFullContent() throws IOException {
        // File file = new File(this.fullRepoPath);

        System.out.println("reading full content...");
        if (!this.fileObject.exists()) {
            this.flagError();
            System.out.println("File is not found.");
            System.out.println("Location : " + fullRepoPath);
            return "";
        }

        // FileReader fReader = new FileReader(file);
        // BufferedReader bufReader = new BufferedReader(new FileReader(file));

        InputStream inputStream = new FileInputStream(this.fileObject);

        String fullContent = IOUtils.toString(inputStream, "utf8");
        String s = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        notify();
        return fullContent;
    }

    protected boolean writeFullContent(String content) throws IOException {

        File file = new File(fullRepoPath);
        if (!file.exists()) {
            boolean isCreated = file.createNewFile();
            if (!isCreated) {
                // throw new Exception("File creation failed");
                System.out.println("File creation failed");
                return false;
            }
        }
        FileWriter writer = new FileWriter(this.fullRepoPath);
        writer.write(content);
        writer.close();
        return true;
    }

    // abstract public int handlingFileError(String errorMsg);

    // abstract public void handlingError(String errorMsg, String stackTrace);

}
