package web.service;

import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserService {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    User getUserByName(String username);
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(User user);
    User getById(Long id);

}
