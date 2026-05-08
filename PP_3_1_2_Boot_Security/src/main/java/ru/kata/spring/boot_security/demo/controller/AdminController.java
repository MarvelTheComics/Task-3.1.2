package ru.kata.spring.boot_security.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "admin/list";
    }

    @GetMapping(params = "id")
    public  String getUserByID(@RequestParam(name = "id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserByID(id));
        return "admin/edit";
    }


    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/admin/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        userService.delete(id);
        return "redirect:/admin/";
    }




}
