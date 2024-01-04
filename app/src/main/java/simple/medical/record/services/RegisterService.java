package simple.medical.record.services;

import simple.medical.record.CLIFormFetcher;

import java.lang.String;

import simple.medical.record.validation.EnumsField;
import simple.medical.record.validation.InputField;
import simple.medical.record.validation.StringField;
import simple.medical.record.validation.PasswordField;

import java.sql.Date;
import java.util.concurrent.Callable;
import java.util.ArrayList;

import simple.medical.record.domains.Address;
import simple.medical.record.domains.Person;
import simple.medical.record.repository.PersonRepo;
import simple.medical.record.utils.Cypher;
import simple.medical.record.utils.PasswordCypher;

public class RegisterService {
    Person generatedData;

    public Person getGeneratedData() {
        return this.generatedData;
    }

    public void run() {

        PersonRepo personRepo = new PersonRepo("person.json");

        InputField[] fields = new InputField[] {
                new StringField("firstname"),
                new StringField("lastname"),
                new StringField("email"),
                new StringField("sex"),

                new PasswordField("password"),
                new PasswordField("confirmpassword"),
        };

        InputField[] addrFields = new InputField[] { new StringField("district"), new StringField("province"),
                new StringField("village"), new StringField("street") };

        InputField[] dateFields = new InputField[] { new StringField("day"), new StringField("month"),
                new StringField("year") };

        InputField[] phFields = new InputField[] { new StringField("phoneNumber") };

        CLIFormFetcher<Object> generalUserForm = new CLIFormFetcher<Object>(fields, "user form") {
            @Override()
            public Object convertToClass() {
                return true;
            }
        };

        CLIFormFetcher<Date> dateUserForm = new CLIFormFetcher<Date>(dateFields, "DOB form") {
            @Override()
            public Date convertToClass() {
                return new Date(Integer.parseInt(this.getValue("year")), Integer.parseInt(this.getValue("month")),
                        Integer.parseInt(this.getValue("day")));
            }
        };

        CLIFormFetcher<Address> addressUserForm = new CLIFormFetcher<Address>(addrFields, "Address form") {
            @Override()
            public Address convertToClass() {
                return new Address(this.getValue("street"), this.getValue("village"), this.getValue("district"),
                        this.getValue("province"));
            }
        };
        ArrayList<String> phList = new ArrayList<String>();
        CLIFormFetcher<ArrayList<String>> phForm = new CLIFormFetcher<>(phFields, "phoneNumber form") {
            @Override()
            public ArrayList<String> convertToClass() {
                return phList;
            }
        };
        try {

            generalUserForm.scanForInput();
            addressUserForm.scanForInput();
            dateUserForm.scanForInput();

            String breakpoint = "c";
            System.out.println("Break point to break from form loop : " + breakpoint);
            Boolean isRunning = true;

            while (isRunning) {
                phForm.scanForInput();
                if (!phForm.getValue("phoneNumber").equalsIgnoreCase(breakpoint)) {
                    phList.add(phForm.getValue("phoneNumber"));
                } else {
                    isRunning = false;
                }
            }
        } catch (Exception e) {
        }

        PasswordCypher pwCypher = new Cypher();
        Callable<Person> combineInfo = () -> {
            return new Person(generalUserForm.getValue("firstname"), generalUserForm.getValue("lastname"),
                    generalUserForm.getValue("email"),

                    generalUserForm.getValue("sex"),
                    dateUserForm.getResultObject(),
                    phForm.getResultObject().toArray(new String[0]),
                    addressUserForm.getResultObject(),
                    pwCypher.hash(generalUserForm.getValue("password")));
        };

        try {
            Person Registered = combineInfo.call();
            personRepo.create(Registered);
            this.generatedData = Registered;
        } catch (Exception e) {
            System.out.println("Exception during register : " + e.toString());
        }

    }

}
