package simple.medical.record.utils;

import java.util.UUID;

public class UniqueIdGenerator {

    public static String genId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
