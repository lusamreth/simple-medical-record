
package simple.medical.record.services;

import simple.medical.record.CLIFormFetcher;

import java.lang.String;

import simple.medical.record.validation.InputField;
import simple.medical.record.validation.StringField;
import simple.medical.record.validation.PasswordField;

import java.util.Map;
import java.util.Optional;

import simple.medical.record.repository.PersonRepo;
import simple.medical.record.utils.Cypher;
import simple.medical.record.utils.PasswordCypher;

public class LoginService {

    public static void run() {

        PersonRepo personRepo = new PersonRepo("person.json");
        PasswordField pw = new PasswordField("password");
        InputField[] fields = new InputField[] { new StringField("email"),
                pw };

        CLIFormFetcher<Object> generalUserForm = new CLIFormFetcher<Object>(fields, "user form") {
            @Override()
            public Object convertToClass() {
                return true;
            }
        };

        try {
            generalUserForm.scanForInput();
        } catch (Exception e) {
        }

        String breakpoint = "c";
        System.out.println("Break point to break from form loop : " + breakpoint);

        try {
            // Person Registered = combineInfo.call();
            String email = generalUserForm.getValue("email");
            Optional<Map<String, Object>> isExisted = personRepo.getWithEmail(email);
            PasswordCypher pwCypher = new Cypher();

            if (isExisted.isEmpty()) {
                System.out.println(
                        "The user with this email : " + email + " does not exists!");
            } else {
                String dbPass = isExisted.get().get("password").toString().trim();
                String userPass = generalUserForm.getValue("password").toString().trim();
                Boolean isValid = pwCypher.compare(userPass, dbPass);

                if (isValid) {
                    System.out.println("Login succeeded!");
                } else {
                    System.out.println("Login Failed!");

                }
            }
        } catch (Exception e) {

            System.out.println("System error during login " + e);
        }

    }

}
