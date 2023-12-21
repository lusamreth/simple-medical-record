package simple.medical.record.services;

import simple.medical.record.CLIFormFetcher;

import java.lang.String;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.Dictionary;

import simple.medical.record.validation.EnumsField;
import simple.medical.record.validation.InputField;
import simple.medical.record.validation.StringField;
import simple.medical.record.validation.PasswordField;

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
        // userInfoTmp.put("name", domains1);

    }

    public static void fetchInfo(String fieldName, Scanner scanner, Dictionary<String, String> registry) {
        System.out.print("- Input " + fieldName + ":");
        String result = scanner.nextLine();
        registry.put(fieldName, result);

        // registry.put()
    }
}
