package simple.medical.record;

import java.util.Scanner;
import simple.medical.record.validation.InputField;

import java.util.Dictionary;
import java.util.Hashtable;

public class CLIFormFetcher {
    private Scanner scanner;
    private InputField[] fields;
    private Dictionary<String, String> dataRegistry;

    public CLIFormFetcher(InputField[] fields) {
        this.scanner = new Scanner(System.in);
        this.fields = fields;
        this.dataRegistry = new Hashtable<String, String>();
    }

    public void scanForInput() {
        System.out.println("------ Registration ------");
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
                return;
            }
        }
    }

}
