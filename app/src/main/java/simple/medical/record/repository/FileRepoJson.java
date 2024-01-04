package simple.medical.record.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; // Import the File class
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;

import java.util.ArrayList; // Needed for ArrayList class
import java.util.Dictionary;
import java.util.Map;
import java.util.List;

import com.alibaba.fastjson.JSON;

// custom file reader object
public class FileRepoJson extends FileRepo {

    // tag error if there exception
    private ArrayList<String> loadedContent = new ArrayList<String>();
    // we know first hand that both list contains 200 names each

    // constructor
    public FileRepoJson() {
        super();
    }

    public FileRepoJson(String entryField) {
        super(entryField);
    }

    // normal insertion
    public void insertToFile(String contentLine) throws IOException {

        FileWriter fileWriter = new FileWriter(fullRepoPath);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(contentLine + "\n");
        writer.close();
    }

    // anynomous inner class
    private class JSONWriterImpl implements Runnable {
        private Dictionary<String, Object> content;
        private Function<String, Boolean> Writer;
        private Consumer<Exception> errHandler;

        // String writerPath, Dictionary<String, Object> content
        public JSONWriterImpl(
                Function<String, Boolean> Writer, Dictionary<String, Object> content) {
            this.Writer = Writer;
            this.content = content;
        }

        public void setErrorHandler(Consumer<Exception> errHandler) {
            this.errHandler = errHandler;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()
                    + ", executing writing Json method!");
            try {
                String JSONString = JSON.toJSONString(this.content);
                Boolean status = this.Writer.apply(JSONString);

            } catch (Exception e) {
                this.errHandler.accept(e);
            }
        }
    }

    private class JSONReaderImpl implements Runnable {
        private Callable<String> repoFReader;
        private Consumer<Exception> errorHandler;
        private String fullContent = "";
        private Boolean contentAvailable = false;

        // private FileRepo fileRepo;

        public JSONReaderImpl(Callable<String> repoFileReader, Consumer<Exception> errorHandler) {
            this.repoFReader = repoFileReader;
            this.errorHandler = errorHandler;
        }

        public String getValue() {
            return this.fullContent;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName()
                    + ", executing run() method!");
            try {
                String content = this.repoFReader.call();
                System.out.println(content);
                // String content = this.fileRepo.readFullContent();
                this.fullContent = content;
                this.contentAvailable = true;

            } catch (IOException e) {
                this.errorHandler.accept(e);
            } catch (Exception e) {

                System.out.println("Unhandled Exception Occured");
                System.out.println("Message : " + e.toString());
                System.out.println("StackTrace : " + e.getStackTrace());
            }
        }
    }

    public void writeJsonFile(Dictionary<String, Object> content) throws IOException {
        Function<String, Boolean> repoWriter = new Function<String, Boolean>() {
            @Override
            public Boolean apply(String content) {
                try {
                    return writeFullContent(content);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Consumer<Exception> errHandler = (Exception e) -> {
            System.out.println("Bump Into Error while reading JSON file.");
            System.out.println("File location : " + this.fullRepoPath);
            System.out.println("Json error stack trace : " + e.getStackTrace());

        };

        JSONWriterImpl writer = new JSONWriterImpl(repoWriter, content);
        writer.setErrorHandler(errHandler);
        writer.run();

    }

    public void spawnRunner(Runnable writer) {

        Thread filerRunner = new Thread(writer);
        try {
            filerRunner.join();
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
            e.printStackTrace();
        }

        filerRunner.start();
    }

    public String readJsonFile() {

        Callable<String> repoFReader = new Callable<String>() {
            @Override
            public String call() throws IOException {
                return readFullContent();
            }

        };

        Consumer<Exception> errHandler = (Exception e) -> {
            System.out.println("Bump Into Error while reading JSON file.");
            System.out.println("File location : " + this.fullRepoPath);
            System.out.println("Json error stack trace : " + e.getStackTrace());
        };

        JSONReaderImpl reader = new JSONReaderImpl(repoFReader, errHandler);
        reader.run();

        return reader.fullContent;
    }

}
