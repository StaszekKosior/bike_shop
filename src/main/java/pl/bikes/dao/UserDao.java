package pl.bikes.dao;

import org.springframework.stereotype.Repository;
import pl.bikes.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
    public void update(User user) {
        entityManager.merge(user);
    }
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user)); }

}
