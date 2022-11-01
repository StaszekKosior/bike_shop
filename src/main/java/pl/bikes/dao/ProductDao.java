package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.Bike;
import pl.bikes.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
    }
    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }
    public void update(Product product) {
        entityManager.merge(product);
    }
    public void delete(Product product) {
        entityManager.remove(entityManager.contains(product) ?
                product : entityManager.merge(product)); }
}
