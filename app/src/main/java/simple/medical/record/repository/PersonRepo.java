package simple.medical.record.repository;

import simple.medical.record.repository.FileRepo;

import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;

import simple.medical.record.domains.Person;
import simple.medical.record.domains.Address;
// public Person(String firstname, String lastname, String sex, Date dateofbirth, String[] phoneNumber,
//         Address address,
//         // String address,
//         String password) {

// import simple.medical.record.repository.Ba;

public class PersonRepo extends BaseRepository<Person> {
    private FileRepo fileRepo;

    public PersonRepo(String repoFileName) {
        // fileRepo
        super();
        this.fileRepo = new FileRepo(repoFileName);
    }

    // public Person(String firstname, String lastname, String sex, Date
    // dateofbirth, String[] phoneNumber,
    // // Address address,
    // String address,
    // String password)

    public Person get(String entityId) {
        Date date = new Date(2003, 5, 12);
        Person person1 = new Person("first", "last", "M", date, new String[] { "123233" },
                new Address("b", "c", "c", "c"),
                "1234");

        return person1;
    }

    public Person create(Person entityData) {
        ArrayList<String> content = this.fileRepo.read();
        Date date = new Date(2003, 5, 12);
        Person person1 = new Person("first", "last", "M", date, new String[] { "123233" },
                new Address("b", "c", "c", "c"),
                "1234");
        content.add(person1.getFirstname());
        String[] contentList = this.fileRepo.fromArrayListToStringList(content);

        try {
            this.fileRepo.writeCSVFile(contentList);
        } catch (Exception error) {
            System.out.print(error.toString());
        }

        return person1;
    };

    public void update(String entityId, Person patchData) {

    };

    public void delete(String entityId) {

    };

    public ArrayList<Person> list() {
        Date date = new Date(2003, 5, 12);
        Person person1 = new Person("first", "last", "M", date, new String[] { "123233" },
                new Address("b", "c", "c", "c"),
                "1234");
        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(person1);
        return personList;
    };

}
