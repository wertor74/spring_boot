package ru.wertor.spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.wertor.spring_boot.model.User;
import ru.wertor.spring_boot.service.UserServiceImp;

@Controller
public class UserController {

    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping(value = "/")
    public String printWelcome (Model model) {
        String message = "CRUD приложение";
        model.addAttribute("message", message);
        return "index";
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("user", userServiceImp.findAll());
        return "users";
    }

    @GetMapping(value = "/{id}")
    public String showUserFromId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.findById(id));
        return "user";
    }

    @GetMapping("/add")
    public String addNewUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImp.findById(id));
        return "edit";
    }

    @PatchMapping(value = "/{id}/edit")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImp.deleteById(id);
        return "redirect:/users";
    }
}
