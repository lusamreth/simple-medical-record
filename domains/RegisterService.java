package Medical_Record;

import java.lang.String;
import java.util.Date;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Dictionary;

public class RegisterService {

    public static void main(String[] args) {
        Dictionary<String, String> userInfoTmp = new Hashtable<String, String>();

        InputField[] fields = { new StringField("firstname"), new StringField("lastname"),
                new EnumsField("sex", new String[] { "m", "f" }),
                new PasswordField(5, 24)
        };
        CLIFormFetcher cliScanner = new CLIFormFetcher(fields);
        cliScanner.scanForInput();
        // for (int i = 0; i < fields.length; i++) {
        // // fetchInfo(fields[i], new Scanner(System.in), userInfoTmp);
        // }
        Scanner sc = new Scanner(System.in);
        // userInfoTmp.put("name", 1);

    }

    public static void fetchInfo(String fieldName, Scanner scanner, Dictionary<String, String> registry) {
        System.out.print("- Input " + fieldName + ":");
        String result = scanner.nextLine();
        registry.put(fieldName, result);

        // registry.put()
    }
}

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
            }
        }
    }

}

// @FunctionalInterface
// interface Function {
// void apply();
// }
public abstract class InputField {
    private String fieldValue;
    private String fieldName;
    private String fieldErrMsg;

    public InputField(String fieldName) {
        this.fieldName = fieldName;
        this.fieldErrMsg = fieldName + " field has an unknown Exception";
    }

    public String getValue() {
        return this.fieldValue.trim();
    }

    public void setValue(String value) {
        this.fieldValue = value;
    }

    public void setFieldError(String error) {
        this.fieldErrMsg = error;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String verify() throws Exception {
        if (this.getValue() == "" || this.getValue() == null) {
            throw new Exception("Empty Value");
        }
        boolean res = this.Validator();

        if (!res) {
            throw new Exception(this.fieldErrMsg);
        } else {
            return this.getValue();
        }

    };

    public abstract boolean Validator();
}

public class StringField extends InputField {

    public StringField(String fieldName) {
        super(fieldName);
    }

    @Override
    public boolean Validator() {
        // check none empty !!
        if (this.getValue() == "") {
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
        String warning = "";
        for (int i = 0; i < this.EnumValues.length; i++) {
            warning += this.EnumValues[i] + ",";
        }
        this.setFieldError(fieldName + " should only contain " + "[" + warning + "]");
    }

    @Override
    public boolean Validator() {
        boolean isValid = false;
        for (int i = 0; i < this.EnumValues.length; i++) {
            if (EnumValues[i].equalsIgnoreCase(this.getValue())) {
                return true;
            }
        }

        return isValid;
    }
}

public class PasswordField extends InputField {
    //
    private String SpecialCases = "@#$%^&+=";
    private Integer minLen = 8;
    private Integer maxLen = 24;

    public PasswordField() {
        super("password");
        this.setFieldError(this.getFieldName() + " is invalid!");
    }

    public PasswordField(Integer minLen, Integer maxLen) {
        super("password");
        this.setFieldError(this.getFieldName() + " is invalid!");
        this.maxLen = maxLen;
        this.minLen = minLen;
    }

    @Override
    public boolean Validator() {
        boolean isValid = false;
        String inputValue = this.getValue();

        if (inputValue.length() < minLen) {
            this.setFieldError("Password must not be below" + minLen + " characters!");
            return false;
        }

        if (inputValue.length() > maxLen) {
            this.setFieldError("Password must not exceed " + maxLen + " characters!");
            return false;
        }

        for (int j = 0; j < inputValue.length(); j++) {
            char charValue = inputValue.charAt(j);
            for (int i = 0; i < this.SpecialCases.length(); i++) {
                if (this.SpecialCases.charAt(i) == charValue) {
                    isValid = true;
                    break;
                }
            }
        }

        if (!isValid) {
            this.setFieldError("Password must contain at least one special character!");
        }

        return isValid;
    }
}
