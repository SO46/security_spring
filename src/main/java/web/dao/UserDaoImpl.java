package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import web.model.Role;
import web.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        List<Role> allRoles = entityManager.createQuery("from Role ", Role.class).getResultList();
        return allRoles;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class,id);
    }

    @Override
    public List<User> allUsers() {
        List<User> allUsers = entityManager.createQuery("from User ", User.class).getResultList();
        return allUsers;
    }
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }
    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }
    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }
    @Override
    public User getById(Long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public User getByName(String name) {
        return entityManager.find(User.class, name);
    }
}