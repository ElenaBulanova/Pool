package com.example.pool.controllers;

import com.example.pool.model.Fine;
import com.example.pool.model.PoolTable;
import com.example.pool.services.FineService;
import com.example.pool.services.PoolTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/fines")
public class FineController {

    private final FineService fineService;

    @GetMapping
    public String fines(Model model) {
        Fine fine = new Fine();
        model.addAttribute("fine", fine);
        model.addAttribute("fines", fineService.findAll());
        return "/pages/fines";
    }
    @GetMapping("/{id}")
    public String getEditPage(Model model, @PathVariable String id) {
        model.addAttribute("fine", fineService.findById(Integer.parseInt(id)));
        model.addAttribute("fines", fineService.findAll());
        return "/pages/fines";
    }
    @PostMapping
    public String add(Fine fine) {
        fineService.save(fine);
        return "redirect:/admin/fines";
    }
    @PostMapping("/{id}")
    public String update(Fine fine) {
        fineService.update(fine);
        return "redirect:/admin/fines";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        fineService.delete(Integer.parseInt(id));
        return "redirect:/admin/fines";
    }
    @PostMapping("/back")
    public String back() {
        return "redirect:/admin";
    }

}
