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


    // Название товара: 1, Название другого товара: 5
    private final Map<Long, Integer> cart = new HashMap<>();

    @Autowired
    private ProductAnimalRepo productAnimalRepo;

    @GetMapping("/cart")
    public String cart(Model model) {
        commnModel(model);

        return "cart";
    }

    @GetMapping("/")
    public String index(Model model) {
        commnModel(model);

        return "index";
    }

    @GetMapping("/creator")
    public String creator(Model model) {
        commnModel(model);

        return "creator";
    }

    @PostMapping("/buy")
    public String buy(Model model, @RequestParam Long id) {
        commnModel(model);

        Integer purchased = cart.getOrDefault(id, 0);
        cart.put(id, purchased + 1);

        return "redirect:/cart";
    }

    @PostMapping("/sell")
    public String sell(Model model, @RequestParam Long id) {
        commnModel(model);

        Integer purchased = cart.getOrDefault(id, 0);

        if (purchased > 0) {
            cart.put(id, purchased - 1);
        }

        return "redirect:/cart";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute ProductAnimal productAnimal) {
        commnModel(model);
        productAnimalRepo.save(productAnimal);
        return "redirect:/";
    }

    @PostMapping("/clear")
    public String clear(Model model) {
        commnModel(model);
        cart.clear();
        return "redirect:/cart";
    }

    private void commnModel(Model model) {
        model.addAttribute("products", productAnimalRepo.findAll());
        model.addAttribute("cart", cart);
    }
}
