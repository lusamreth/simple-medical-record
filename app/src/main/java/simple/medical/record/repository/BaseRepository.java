package simple.medical.record.repository;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public abstract class BaseRepository<Entity> {
    abstract public Entity get(String entityId);

    abstract public Entity create(Entity entityData);

    abstract public void update(String entityId, Entity patchData);

    abstract public void delete(String entityId);

    abstract public List<Entity> list();

}

// class RepoSerializer {
// protected String fieldEntry;
// private Map<String, Object> dataObject;

// public RepoSerializer(String fieldEntry) {
// this.fieldEntry = fieldEntry;
// }
// }

// shared resource -> read the whole db.json -> serializer -> parse all of it
// public class BaseRepoImpl<Entity> extend {
// }
