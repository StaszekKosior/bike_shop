package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.Bike;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BikeDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Bike bike) {
        entityManager.persist(bike);
    }
    public Bike findById(long id) {
        return entityManager.find(Bike.class, id);
    }
    public void update(Bike bike) {
        entityManager.merge(bike);
    }
    public void delete(Bike bike) {
        entityManager.remove(entityManager.contains(bike) ?
                bike : entityManager.merge(bike)); }

}
