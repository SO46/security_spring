package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public void edit(User user) {
        userDao.edit(user);
    }
    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }
}
