package ru.kata.spring.boot_security.demo.controller;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.AdminService;

import java.util.HashSet;
import java.util.List;


@Controller
@RequestMapping("/index")
public class AuthController {

    private final AdminService adminService;
    @Autowired
    public AuthController(AdminService adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    private String indexPage() {
        return "shared/index";
    }

    @GetMapping("/registration")
    private String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "shared/registration";
    }

    @PostMapping("/registration")
    private String createUser(@ModelAttribute("user") User user) {
        adminService.add(user);
        return "redirect:/login";
    }
}
