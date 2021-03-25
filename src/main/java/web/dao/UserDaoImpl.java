package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        List<User> allUsers = entityManager.createQuery("from User ", User.class)
                .getResultList();
        return allUsers;
    }
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
    @Override
    public User getById(int id) {
        return entityManager.find(User.class,id);
    }
}