package com.example.pool.controllers;

import com.example.pool.model.PoolTable;
import com.example.pool.services.PoolTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/pooltables")
public class PoolTableController {
    private final PoolTableService poolTableService;

    @GetMapping
    public String pooltables(Model model) {
        PoolTable table = new PoolTable();
        model.addAttribute("table", table);
        model.addAttribute("tables", poolTableService.findAll());
        return "/pages/pooltables";
    }

    @GetMapping("/{id}")
    public String getEditPage(Model model, @PathVariable String id) {
        model.addAttribute("table", poolTableService.findById(Integer.parseInt(id)));
        model.addAttribute("tables", poolTableService.findAll());
        return "/pages/pooltables";
    }

    @PostMapping
    public String add(PoolTable table) {
        poolTableService.save(table);
        return "redirect:/admin/pooltables";
    }
    @PostMapping("/{id}")
    public String update(PoolTable table) {
        poolTableService.update(table);
        return "redirect:/admin/pooltables";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
//        System.out.println("id = " + id + " " + Integer.parseInt(id));
        poolTableService.delete(Integer.parseInt(id));
        return "redirect:/admin/pooltables";
    }
    @PostMapping("/back")
    public String back() {
        return "redirect:/admin";
    }

}
