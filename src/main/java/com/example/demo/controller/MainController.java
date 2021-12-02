package com.example.demo.controller;

import com.example.demo.enities.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    ProductAnimalRepo productAnimalRepo;

    private List<ProductAnimal> products;

    @PostConstruct
    private void init() {
        products = productAnimalRepo.findAll();
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", products);
        return "cart";
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String string) {
        model.addAttribute("products", products);
        return "index";
    }

    @PostMapping("/buy")
    public String buy(Model model, @RequestParam Integer id) {
        ProductAnimal prodAnima = products.get(id);
        Integer previousValue = prodAnima.getNumberPurchases();
        prodAnima.setNumberPurchases(previousValue + 1);

        model.addAttribute("products", products);
        return "redirect:/cart";
    }

    @PostMapping("/sell")
    public String sell(Model model, @RequestParam Integer id) {

        ProductAnimal prodAnima = products.get(id);
        Integer previousValue = prodAnima.getNumberPurchases();
        prodAnima.setNumberPurchases(previousValue - 1);

        model.addAttribute("products", products);
        return "redirect:/cart";
    }
}
