package simple.medical.record.repository;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<Entity> {
    abstract public <T> Optional<T> get(String entityId);

    abstract public Entity create(Entity entityData);

    abstract public void update(String entityId, Entity patchData);

    abstract public void delete(String entityId);

    abstract public List<Entity> list();

    abstract public <T> List<T> listGeneric();

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
