package simple.medical.record.repository;

import java.util.Dictionary;
import java.util.List;
import java.util.Hashtable;

import java.lang.reflect.Field;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;

import java.util.ArrayList;

import simple.medical.record.domains.Person;

public class PersonRepo extends BaseRepository<Person> {
    private FileRepoJson fileRepo;

    private Hashtable<String, Object> memoryData = new Hashtable<String, Object>();
    private List<Person> personList;

    public PersonRepo(String repoFileName) {
        super();
        this.fileRepo = new FileRepoJson();
    }

    public Optional<Map<String, Object>> get(String entityId) {
        List<Object> personList = this.listGeneric();

        for (Object item : personList) {
            Map<String, Object> casted = (Map<String, Object>) (item);
            System.out.println(casted);
            if (casted.get("userId").toString().equalsIgnoreCase(entityId)) {
                return Optional.of(casted);
            }
        }
        return Optional.empty();

    }

    public Optional<Map<String, Object>> getWithFullName(String firstName, String lastName) {
        List<Object> personList = this.listGeneric();

        for (Object item : personList) {
            Map<String, Object> casted = (Map<String, Object>) (item);
            System.out.println(casted);
            if (casted.get("firstname").toString().equalsIgnoreCase(firstName)
                    && casted.get("lastname").toString().equalsIgnoreCase(lastName)) {
                return Optional.of(casted);
            }
        }
        return Optional.empty();

    }

    public Optional<Map<String, Object>> getWithEmail(String email) {
        List<Object> personList = this.listGeneric();

        for (Object item : personList) {
            Map<String, Object> casted = (Map<String, Object>) (item);
            System.out.println(casted);
            if (casted.get("email").toString().equalsIgnoreCase(email)) {
                return Optional.of(casted);
            }
        }
        return Optional.empty();

    }

    public static Dictionary<String, Object> convertToMap(Object obj) {
        Dictionary<String, Object> map = new Hashtable<String, Object>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true); // This line allows us to access private fields
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return map;
    }

    public Person create(Person entityData) {
        String actualContent = this.fileRepo.readJsonFile();
        System.out.println(actualContent);
        List<Person> personList = this.list();
        System.out.println("PERSONNNNNNNNNNN " + personList.size());
        try {
            System.out.println("Writing to file..." + entityData);
            System.out.println("Content Data : " + this.memoryData);
            personList.add(entityData);
            // Person da = personList.get(2);

            this.memoryData.put("Person", personList);
            this.fileRepo.writeJsonFile(this.memoryData);

        } catch (Exception error) {
            System.out.print("Error during write operation: " + error.toString());
        }

        return entityData;
    };

    public void memoryReload() {

        String content = this.fileRepo.readJsonFile();
        Hashtable<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        this.memoryData = ccd;
    }

    public void loadToMem(Object data) {
        this.memoryData.put("Person", data);
    }

    public void update(String entityId, Person patchData) {
        System.out.println("updating....");
        this.memoryReload();
        List<Object> personList = this.listGeneric();

        System.out.println("buggie");
        System.out.println(personList);
        // Dictionary<String, Object> da = (Hashtable) personList.get(0);

        boolean isRemoved = personList.removeIf((per) -> {
            Map<String, Object> pp = (Map<String, Object>) per;
            if (pp.get("userId") == null) {
                System.out.println("Corrupted file schema in person!");
                return false;
            }
            if (pp.get("userId").toString().equalsIgnoreCase(entityId)) {
                return true;
                // Dictionary<String, Object> partial = PersonRepo.convertToMap(patchData);
                // Dictionary<String, Object> originalData =
                // MapUtils.convertMapToDictionary(pp);
                // MapUtils.compareAndReplaceDict(originalData, partial,
                // new ArrayList<String>());
                // System.out.println("FOUNDD ->" + " " + originalData);
                // personList.add(originalData);
            }
            return false;
            // this.loadToMem();
        });

        if (isRemoved) {
            personList.add(patchData);
        }

        this.loadToMem(personList);
        try {
            this.fileRepo.writeJsonFile(this.memoryData);
        } catch (Exception error) {
            System.out.print("Error during update operation: " + error.toString());
        }

    };

    public void delete(String entityId) {

    };

    public List<Person> list() {

        System.out.println("List is called");
        String content = this.fileRepo.readJsonFile();
        if (content == "") {
            return new ArrayList<Person>();
        }
        Dictionary<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        // System.out.println("CDD " + content + ccd);
        try {

            List<Person> personList = (List<Person>) ccd.get("Person");
            this.personList = personList;
            return personList;

        } catch (ClassCastException e) {
            System.out.println("DOMAIN NAME : " + "Person");
            System.out.println("Corrupted Data during type casting...");
            e.printStackTrace();
            return new ArrayList<Person>();
        } catch (Exception e) {
            System.out.println("DOMAIN NAME : " + "Person");
            System.out.println("Dictionay Error...");
            e.printStackTrace();
            return new ArrayList<Person>();
        }

    };

    public List<Object> listGeneric() {

        System.out.println("List is called");
        String content = this.fileRepo.readJsonFile();
        if (content == "") {
            return new ArrayList<Object>();
        }
        Dictionary<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        // System.out.println("CDD " + content + ccd);
        try {

            List<Object> personList = (List<Object>) ccd.get("Person");
            return personList;

        } catch (ClassCastException e) {
            System.out.println("DOMAIN NAME : " + "Person");
            System.out.println("Corrupted Data during type casting...");
            e.printStackTrace();
            return new ArrayList<Object>();
        } catch (Exception e) {
            System.out.println("DOMAIN NAME : " + "Person");
            System.out.println("Dictionay Error...");
            e.printStackTrace();
            return new ArrayList<Object>();
        }

    };
}
