package Medical_Record;

import java.lang.String;
import java.util.Date;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Dictionary;

public class RegisterService {

    public static void main(String[] args) {
        Dictionary<String, String> userInfoTmp = new Hashtable<String, String>();

        // String inputFirstName;
        // String inputLastName;
        // String passwordTmp;
        // String inputSex;
        // String[] fields = { "firstname", "lastname", "sex", "date of birth",
        // "address", "phone number", "email",
        // "password" };

        InputField[] fields = { new StringField("firstname") };
        StringField ss = new StringField("Fieldnam");
        for (int i = 0; i < fields.length; i++) {
            // fetchInfo(fields[i], new Scanner(System.in), userInfoTmp);
        }
        Scanner sc = new Scanner(System.in);
        // userInfoTmp.put("name", 1);

    }

    public static void fetchInfo(String fieldName, Scanner scanner, Dictionary<String, String> registry) {
        System.out.print("- Input " + fieldName + ":");
        String result = scanner.nextLine();
        registry.put(fieldName, result);

        // registry.put()
    }

    // public static void fetchInfo(String fieldName, Scanner scanner,
    // Dictionary<String, String> registry) {
    // System.out.print("- Input " + fieldName + ":");
    // String result = scanner.nextLine();
    // registry.put(fieldName, result);

    // // registry.put()
    // }

}

public class CLIFormFetcher {
    private Scanner scanner;
    private InputField fields;

    public CLIFormFetcher() {
        this.scanner = new Scanner(System.in);
    }
}

// @FunctionalInterface
// interface Function {
// void apply();
// }
public abstract class InputField {
    private String fieldValue;
    private String fieldName;

    public InputField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return this.fieldValue;
    }

    public void setValue(String value) {
        this.fieldValue = value;
    }

    public abstract boolean Validator();
}

public class StringField extends InputField {

    public StringField(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean Validator() {
        if (this.getValue() != "") {
            return false;
        }
        return true;
    }
}

public class EnumsField extends InputField {
    private String[] EnumValues;

    public EnumsField(String fieldName, String[] validValues) {
        super(fieldName);
        this.EnumValues = validValues;
    }

    @Override
    public boolean Validator() {
        if (this.getValue() != "") {
            return false;
        }
        boolean isValid = false;
        for (int i = 0; i < this.EnumValues.length; i++) {
            if (EnumValues[i] == this.getValue()) {
                isValid = true;
                break;
            }
        }

        return isValid;
    }
}
