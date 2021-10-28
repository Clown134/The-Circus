package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    public static Integer count = 0;

    public List<Integer> countByProduct = new ArrayList<>();

    {
        countByProduct.add(0);
        countByProduct.add(0);
        countByProduct.add(0);
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("countByProduct", countByProduct);
        return "cart";
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String string) {
        model.addAttribute("message", string);
        return "index";
    }

    @GetMapping("/buy")
    public String buy(Model model, @RequestParam(required = false) Integer id) {

        Integer previousValue = countByProduct.get(id);
        countByProduct.set(id, previousValue + 1);

        model.addAttribute("message", id);
        return "index";
    }

    @GetMapping("/sell")
    public String sell(Model model, @RequestParam(required = false) Integer id) {

        Integer previousValue = countByProduct.get(id);
        countByProduct.set(id, previousValue - 1);

        model.addAttribute("message", id);
        return "index";
    }
}
