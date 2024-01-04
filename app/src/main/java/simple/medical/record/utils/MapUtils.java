package simple.medical.record.utils;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Enumeration;

public class MapUtils {

    public static void compareAndReplaceDict(Dictionary<String, Object> primary,
            Dictionary<String, Object> secondary, List<String> exclude) {

        Enumeration<String> primaryKeys = primary.keys();
        System.out.println("bruh" + primary + secondary);
        while (primaryKeys.hasMoreElements()) {

            String key = primaryKeys.nextElement();
            Object value = primary.get(key);
            Object value_second = secondary.get(key);

            if (exclude.contains(key)) {
                continue;
            }
            if (value_second == null) {
                continue;
            }
            if (!value.toString().equalsIgnoreCase(value_second.toString())) {
                System.out.println("bruh change");
                primary.put(key, value_second);
            }
        }
    }

    public static <K, V> Hashtable<K, V> convertMapToDictionary(Map<K, V> map) {
        Hashtable<K, V> dictionary = new Hashtable<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            dictionary.put(entry.getKey(), entry.getValue());
        }
        return dictionary;
    }
}
