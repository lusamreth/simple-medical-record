package simple.medical.record;

import java.util.Scanner;
import simple.medical.record.validation.InputField;

import java.util.Dictionary;
import java.util.Hashtable;

abstract public class CLIFormFetcher<T> {
    private Scanner scanner;
    private InputField[] fields;
    private Dictionary<String, String> dataRegistry;
    private T resultObject;
    private String title;
    private Boolean hasException;

    public CLIFormFetcher(InputField[] fields, String title) {
        this.scanner = new Scanner(System.in);
        this.fields = fields;
        this.dataRegistry = new Hashtable<String, String>();
        this.title = title;
    }

    public CLIFormFetcher(InputField[] fields) {
        this.scanner = new Scanner(System.in);
        this.fields = fields;
        this.dataRegistry = new Hashtable<String, String>();
    }

    public void scanForInput() throws Exception {
        if (this.title != null) {
            System.out.println("------ " + title + "------");
        }
        for (int i = 0; i < this.fields.length; i++) {
            InputField field = this.fields[i];
            String fieldName = field.getFieldName();
            System.out.print(fieldName + ": ");

            String rawValue = this.scanner.nextLine();
            field.setValue(rawValue);

            try {
                this.dataRegistry.put(fieldName, field.verify());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new RuntimeException();
            }
        }
    }

    public void recursiveAsk(String breakpoint) {

    }

    public String getValue(String fieldname) {
        return this.dataRegistry.get(fieldname);
    }

    public void setResultObject(T object) {
        this.resultObject = object;
    }

    public T getResultObject() {
        if (this.resultObject == null) {
            this.setResultObject(convertToClass());
        }

        return resultObject;
    }

    abstract public T convertToClass();
}
