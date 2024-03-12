package com.example.pool.controllers;

import com.example.pool.model.Client;
import com.example.pool.services.ClientService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/clients")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public String clients(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("clients", clientService.findAll());
        return "/pages/clients";
    }
    @GetMapping("/{id}")
    public String getEditPage(Model model, @PathVariable String id) {
        System.out.println("id = " + id);
        model.addAttribute("client", clientService.findById(Integer.parseInt(id)));
        model.addAttribute("clients", clientService.findAll());
        System.out.println("birthday = " );
        return "/pages/clients";
    }
    @PostMapping
    public String add(Client client) {
        System.out.println("cl = " + client.toString());
//        clientService.save(client);
        return "redirect:/admin/clients";
    }
    @PostMapping("/{id}")
    public String update(Client client) {
        clientService.update(client);
        return "redirect:/admin/clients";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        clientService.delete(Integer.parseInt(id));
        return "redirect:/admin/clients";
    }
    @PostMapping("/back")
    public String back() {
        return "redirect:/admin";
    }
}
