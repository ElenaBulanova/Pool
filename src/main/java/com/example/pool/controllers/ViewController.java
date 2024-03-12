package com.example.pool.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/admin")
@RequestMapping("/")
public class ViewController {
    @GetMapping
    public String home() {
      //  return "pages/index";
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/pages/admin";
    }
    @GetMapping("/login")
    public String login(){
        return "/pages/login";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("auth.getName() = " + auth.getName());
        model.addAttribute("username", auth.getName());
        return "pages/profile";
    }

    @GetMapping("/register")
    @PreAuthorize("permitAll()")
    public String register() {
        return "pages/register";
    }
}
