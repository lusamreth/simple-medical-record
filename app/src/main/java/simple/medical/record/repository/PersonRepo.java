package simple.medical.record.repository;

import simple.medical.record.repository.FileRepo;

import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

import java.lang.reflect.Field;
import java.util.Map;

import java.util.function.Function;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collection;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerator;

import java.util.ArrayList;
import java.util.Collection;

import simple.medical.record.domains.Person;
import simple.medical.record.domains.Address;

public class PersonRepo extends BaseRepository<Person> {
    private FileRepoJson fileRepo;

    private Hashtable<String, Object> memoryData = new Hashtable<String, Object>();

    public PersonRepo(String repoFileName) {
        // fileRepo
        super();
        this.fileRepo = new FileRepoJson();
    }

    public Person get(String entityId) {
        Date date = new Date(2003, 5, 12);
        Person person1 = new Person("first", "last", "M", date, new String[] { "123233" },
                new Address("b", "c", "xxx", "c"),
                "1234");

        return person1;
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
        // ArrayList<String> content = this.fileRepo.read();
        this.memoryReload();
        String actualContent = this.fileRepo.readJsonFile();
        System.out.println(actualContent);
        List<Person> personList = this.list();
        System.out.println("PERSONNNNNNNNNNN " + personList.size());
        // ObjectMapper Obj = new ObjectMapper();

        try {
            System.out.println("Writing to file...");
            System.out.println("Content Data : " + this.memoryData);
            personList.add(entityData);

            this.memoryData.put("Person", personList);
            System.out.println("MEMA " + this.memoryData);
            this.fileRepo.writeJsonFile(this.memoryData);

        } catch (Exception error) {
            System.out.print("Error during write operation: " + error.toString());
        }

        return entityData;
    };

    public void memoryReload() {

        String content = this.fileRepo.readJsonFile();
        if (content == "") {
            this.memoryData = new Hashtable<String, Object>();
            return;
        }
        Hashtable<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        this.memoryData = ccd;
    }

    public static void compareAndReplaceDict(Dictionary<String, Object> primary,
            Dictionary<String, Object> secondary, List<String> exclude) {

        Enumeration<String> primaryKeys = primary.keys();

        while (primaryKeys.hasMoreElements()) {

            String key = primaryKeys.nextElement();
            Object value = primary.get(key);
            Object value_second = secondary.get(key);
            if (exclude.contains(key)) {
                continue;
            }

            if (value.toString() != value_second.toString()) {
                primary.put(key, value_second);
            }

        }
    }

    public void update(String entityId, Person patchData) {
        // if (memoryData.isEmpty()) {
        // this.memoryReload();
        // }
        List<Person> personList = this.list();

        personList.forEach(per -> {
            if (per.getUserId() == entityId) {
                Dictionary<String, Object> partial = PersonRepo.convertToMap(patchData);
                Dictionary<String, Object> originalData = PersonRepo.convertToMap(per);
                PersonRepo.compareAndReplaceDict(originalData, partial, new ArrayList<String>());
                return;
            }
        });
        // System.out.println("pppp" + pp);
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
            System.out.println("CDD " + personList.size());
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

}
