package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.Accessorie;
import pl.bikes.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AccessoriesDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Accessorie accessorie) {
        entityManager.persist(accessorie);
    }
    public Accessorie findById(Long id) {
        return entityManager.find(Accessorie.class, id);
    }
    public void update(Accessorie accessorie) {
        entityManager.merge(accessorie);
    }
    public void delete(Accessorie accessorie) {
        entityManager.remove(entityManager.contains(accessorie) ?
                accessorie : entityManager.merge(accessorie)); }

}

