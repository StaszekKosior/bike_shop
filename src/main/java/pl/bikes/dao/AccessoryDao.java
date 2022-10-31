package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.Accessory;
import pl.bikes.model.Bike;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccessoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Accessory accessory) {
        entityManager.persist(accessory);
    }
    public Accessory findById(long id) {
        return entityManager.find(Accessory.class, id);
    }
    public void update(Accessory accessory) {
        entityManager.merge(accessory);
    }
    public void delete(Accessory accessory) {
        entityManager.remove(entityManager.contains(accessory) ?
                accessory : entityManager.merge(accessory)); }

}
