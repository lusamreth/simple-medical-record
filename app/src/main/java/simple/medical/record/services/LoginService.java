
package simple.medical.record.services;

import simple.medical.record.CLIFormFetcher;
import simple.medical.record.domains.Person;

import java.lang.String;

import simple.medical.record.validation.InputField;
import simple.medical.record.validation.StringField;
import simple.medical.record.validation.PasswordField;

import java.util.Map;
import java.util.Optional;

import simple.medical.record.repository.PersonRepo;
import simple.medical.record.utils.Cypher;
import simple.medical.record.utils.PasswordCypher;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

public class LoginService {
    public Boolean isLogin = false;
    public Person personInfo;

    public Boolean getLogin() {
        return isLogin;
    }

    public void run() {

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

        String email = generalUserForm.getValue("email");

        Gson gson = new Gson();

        try {
            Optional<Map<String, Object>> rawInfo = personRepo.getWithEmail(email);
            //
            // Person Registered = combineInfo.call();
            // String email = generalUserForm.getValue("email");
            // Optional<Map<String, Object>> isExisted = personRepo.getWithEmail(email);
            PasswordCypher pwCypher = new Cypher();
            // System.out.println(rawInfo);
            if (rawInfo.isEmpty()) {
                System.out.println(
                        "The user with this email : " + email + " does not exists!");
            } else {
                System.out.println("GSONNN " + rawInfo);
                Person personInfo = gson.fromJson(rawInfo.get().toString(), Person.class);
                String dbPass = personInfo.getPassword().toString().trim();
                String userPass = generalUserForm.getValue("password").toString().trim();
                Boolean isValid = pwCypher.compare(userPass, dbPass);

                if (isValid) {
                    System.out.println("Login succeeded!");
                    this.isLogin = true;
                    this.personInfo = personInfo;
                } else {
                    System.out.println("Login Failed!");

                }
            }
        } catch (Exception e) {

            System.out.println("System error during login " + e);
        }

    }

}
