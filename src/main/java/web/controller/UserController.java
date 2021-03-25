package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.allUsers();
        model.addAttribute("users", userList);
        return "userList";
    }

    @GetMapping("addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "userEdit";
    }

    @PostMapping("editUser")
    public String editUser(@ModelAttribute("newUser") User user) {
        userService.edit(user);
        return "redirect:/";
    }

    @GetMapping("updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("newUser", userService.getById(id));
        return "userEdit";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}