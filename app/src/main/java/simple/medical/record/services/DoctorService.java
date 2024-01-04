
package simple.medical.record.services;

import simple.medical.record.CLIFormFetcher;
import simple.medical.record.domains.Doctor;
import simple.medical.record.domains.Person;

import java.lang.String;

import simple.medical.record.validation.InputField;
import simple.medical.record.validation.StringField;
import simple.medical.record.validation.PasswordField;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;

import simple.medical.record.repository.DoctorRepo;
import simple.medical.record.utils.Cypher;
import simple.medical.record.utils.PasswordCypher;

public class DoctorService {

    public static void run() {

        DoctorRepo doctorRepo = new DoctorRepo();
        RegisterService Reg = new RegisterService();
        Reg.run();
        InputField[] fields = new InputField[] {
                new StringField("specialty"),
                new StringField("qualification"),
                new StringField("medRecidency"),
                new StringField("description"),
        };

        Person gen = Reg.getGeneratedData();

        CLIFormFetcher<Doctor> generalDoctorForm = new CLIFormFetcher<Doctor>(fields, "user form") {
            @Override()
            public Doctor convertToClass() {
                return new Doctor(gen, this.getValue("specialty"), this.getValue("qualification"),
                        this.getValue("medRecidency"), this.getValue("description"));
                // return true;
            }
        };

        try {
            generalDoctorForm.scanForInput();
        } catch (Exception e) {
            System.out.println("Encountered input error!! " + e);
            e.printStackTrace();
            return;
        }

        // Gson gson = new Gson();

        try {
            // Person Registered = combineInfo.call();
            // String email = generalDoctorForm.getValue("email");
            // Optional<Map<String, Object>> isExisted = personRepo.getWithEmail(email);
            Callable<Doctor> combineInfo = () -> {
                return new Doctor(
                        gen,
                        generalDoctorForm.getValue("specialty"),
                        generalDoctorForm.getValue("qualification"),
                        generalDoctorForm.getValue("medRecidency"),
                        generalDoctorForm.getValue("description"));

            };

            try {
                Doctor Registered = combineInfo.call();
                doctorRepo.create(Registered);
            } catch (Exception e) {
                System.out.println("Exception during register : " + e.toString());
            }
            // if (!isExisted.isEmpty()) {
            // System.out.println(
            // "The user with this email : " + email + " is already exists!");
            // } else {

            // // Person personInfo,
            // // String doctorID,
            // // String specialty, String qualification,
            // // String medRecidency, String description) {
            // }
        }
        // generalUserForm.getValue("firstname"), generalUserForm.getValue("lastname"),
        // generalUserForm.getValue("email"),

        // generalUserForm.getValue("sex"),
        // dateUserForm.getResultObject(),
        // phForm.getResultObject().toArray(new String[0]),
        // addressUserForm.getResultObject(),
        // pwCypher.hash(generalUserForm.getValue("password"))

        catch (Exception e) {

            System.out.println("System error during login " + e);
        }

    }

}
