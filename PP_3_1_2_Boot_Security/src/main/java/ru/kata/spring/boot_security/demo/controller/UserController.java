package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.security.UserDetailsImp;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

    @GetMapping("/user")
    public String getUser(@AuthenticationPrincipal UserDetailsImp userDetailsImp, Model model) {
        model.addAttribute("user", userDetailsImp.getUser());
        return "user/userInfo";
    }
}
