package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Order order) {
        entityManager.persist(order);
    }
    public Order findById(long id) {
        return entityManager.find(Order.class, id);
    }
    public void update(Order order) {
        entityManager.merge(order);
    }
    public void delete(Order order) {
        entityManager.remove(entityManager.contains(order) ?
                order : entityManager.merge(order)); }
}
