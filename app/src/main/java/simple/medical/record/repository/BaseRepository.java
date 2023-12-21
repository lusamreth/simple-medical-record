package simple.medical.record.repository;

import java.util.ArrayList;

public abstract class BaseRepository<Entity> {

    abstract public Entity get(String entityId);

    abstract public Entity create(Entity entityData);

    abstract public void update(String entityId, Entity patchData);

    abstract public void delete(String entityId);

    abstract public ArrayList<Entity> list();

}
