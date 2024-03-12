package com.example.pool.controllers;

import com.example.pool.security.dao.UserService;
import com.example.pool.security.entities.db.Role;
import com.example.pool.security.entities.db.Status;
import com.example.pool.security.entities.db.User;
import lombok.RequiredArgsConstructor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class RegistrationController {
    private final UserService userService;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public String register(@RequestParam String username, @RequestParam String password,
                           @RequestParam String passwordRepeat, RedirectAttributes ra) {
        if (userService.findByUsername(username) != null) {
            ra.addFlashAttribute("error", "login");
            return "redirect:/register";
        }

        if (!password.equals(passwordRepeat)) {
            ra.addFlashAttribute("error", "password");
            return "redirect:/register";
        }

        User user = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder(12).encode(password))
                .role(Role.USER)
                .status(Status.ACTIVE)
                .build();
        userService.register(user);
        return "redirect:/";
    }
}
