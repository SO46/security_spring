package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserDao {

    List<Role> getAllRoles();
    Role getRoleById(Long id);
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(Long id);
    User getByName(String name);
}
