package org.example.MySpringBootProject.controller;

import org.example.MySpringBootProject.model.User;
import org.example.MySpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {
    private final UserService user;

    @Autowired
    public UsersController(UserService user) {
        this.user = user;
    }

    @GetMapping("/users")
    public String getUsers(ModelMap model) {
        model.addAttribute("users", user.getUsers());
        return "users";
    }

    @GetMapping("/users/new")
    public String createUserForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user) {
        this.user.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public void edit(@RequestParam("id") int id, ModelMap model) {
        model.addAttribute("user", user.getUserById(id));
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user) {
        this.user.edit(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        user.delete(id);
        return "redirect:/users";
    }
}