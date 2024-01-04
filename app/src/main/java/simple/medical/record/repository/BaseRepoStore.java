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

public class BaseRepoStore<Generic> extends BaseRepository<Generic> {
    private FileRepoJson fileRepo;
    private Hashtable<String, Object> memoryData = new Hashtable<String, Object>();
    private List<Generic> genericList;
    private String fieldname;

    public BaseRepoStore(String fieldname) {
        super();
        this.fieldname = fieldname;
        this.fileRepo = new FileRepoJson(fieldname);
    }

    public Optional<Map<String, Object>> get(String entityId) {
        List<Object> genericList = this.listGeneric();

        for (Object item : genericList) {
            Map<String, Object> casted = (Map<String, Object>) (item);
            System.out.println(casted);
            if (casted.get("userId").toString().equalsIgnoreCase(entityId)) {
                return Optional.of(casted);
            }
        }
        return Optional.empty();

    }

    public Optional<Map<String, Object>> getWithFullName(String firstName, String lastName) {
        List<Object> genericList = this.listGeneric();

        for (Object item : genericList) {
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
        List<Object> genericList = this.listGeneric();

        for (Object item : genericList) {
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

    public Generic create(Generic entityData) {
        System.out.println("Creatingg..." + this.fieldname);
        List<Object> genericList = this.listGeneric();
        System.out.println("Genooooooo " + genericList + " " + this.listGeneric());
        try {
            System.out.println("Writing to file..." + entityData);
            System.out.println("Content Data : " + this.memoryData);
            genericList.add(entityData);

            this.memoryData.put(fieldname, genericList);
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
        this.memoryData.put(this.fieldname, data);
    }

    public void update(String entityId, Generic patchData) {
        System.out.println("updating....");
        this.memoryReload();
        List<Object> genericList = this.listGeneric();

        System.out.println("buggie");
        System.out.println(genericList);
        // Dictionary<String, Object> da = (Hashtable) genericList.get(0);

        boolean isRemoved = genericList.removeIf((per) -> {
            Map<String, Object> pp = (Map<String, Object>) per;
            if (pp.get("userId") == null) {
                System.out.println("Corrupted file schema in generic!");
                return false;
            }
            if (pp.get("userId").toString().equalsIgnoreCase(entityId)) {
                return true;
            }
            return false;
        });

        if (isRemoved) {
            genericList.add(patchData);
        }

        this.loadToMem(genericList);
        try {
            this.fileRepo.writeJsonFile(this.memoryData);
        } catch (Exception error) {
            System.out.print("Error during update operation: " + error.toString());
        }

    };

    public void delete(String entityId) {

        boolean isRemoved = genericList.removeIf((per) -> {
            Map<String, Object> pp = (Map<String, Object>) per;
            if (pp.get("userId") == null) {
                System.out.println("Corrupted file schema in generic!");
                return false;
            }
            if (pp.get("userId").toString().equalsIgnoreCase(entityId)) {
                return true;
            }
            return false;
        });

    };

    public List<Generic> list() {

        System.out.println("List is called");
        String content = this.fileRepo.readJsonFile();

        if (content == "") {
            return new ArrayList<Generic>();
        }

        Dictionary<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        try {

            List<Generic> genericList = (List<Generic>) ccd.get(fieldname);
            this.genericList = genericList;
            return genericList;

        } catch (ClassCastException e) {
            System.out.println("DOMAIN NAME : " + fieldname);
            System.out.println("Corrupted Data during type casting...");
            e.printStackTrace();
            return new ArrayList<Generic>();
        } catch (Exception e) {
            System.out.println("DOMAIN NAME : " + "Generic");
            System.out.println("Dictionay Error...");
            e.printStackTrace();
            return new ArrayList<Generic>();
        }

    };

    public List<Object> listGeneric() {

        System.out.println("List is called");
        String content = this.fileRepo.readJsonFile();
        System.out.println(
                "CDD before" + content + " " + this.fileRepo.fullRepoPath + " " + this.fileRepo.dataEntryPoint);

        if (content == "") {
            return new ArrayList<Object>();
        }
        Dictionary<String, Object> ccd = JSON.parseObject(content, this.memoryData.getClass());
        System.out.println("CDD " + content + ccd);
        try {

            List<Object> genericList = (List<Object>) ccd.get(fieldname);
            return genericList;

        } catch (ClassCastException e) {
            System.out.println("DOMAIN NAME : " + "Generic");
            System.out.println("Corrupted Data during type casting...");
            e.printStackTrace();
            return new ArrayList<Object>();
        } catch (Exception e) {
            System.out.println("DOMAIN NAME : " + "Generic");
            System.out.println("Dictionay Error...");
            e.printStackTrace();
            return new ArrayList<Object>();
        }

    };
}
