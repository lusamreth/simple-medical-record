/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package simple.medical.record;

import java.sql.Date;

import simple.medical.record.domains.Address;
import simple.medical.record.domains.Person;
import simple.medical.record.repository.PersonRepo;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();

        PersonRepo personRepo = new PersonRepo("person.json");

        Date date = new Date(2003, 5, 12);
        Person person1 = new Person("first", "last kskajsjd", "M", date, new String[] { "123233" },
                new Address("b", "xxxxc", "c", "c"),
                "1234");

        Person personMod = new Person("jurk ma", "duma didiovvvvvv", "M", date, new String[] { "123233" },
                new Address("b", "xxxxc", "c", "c"),
                "1234");

        personRepo.create(person1);
        // personRepo.create(person1);
        // personRepo.create(person1);
        // personRepo.create(personMod);
        // personRepo.list();
        // personRepo.update("6ae2d4a-5592-4844-bff4-79a849c248f0",
        // personMod);

        System.out.println(new App().getGreeting());
    }
}
