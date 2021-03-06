package com.example.demo.controller;

import com.example.demo.enities.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainController {


    // Название товара: 1, Название другого товара: 5
    private final Map<Long, Integer> cart = new HashMap<>();

    @Autowired
    private ProductAnimalRepo productAnimalRepo;
    @Autowired
    private HistoryRepo historyRepo;

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

    @GetMapping("/history")
    public String history(Model model) {
        commnModel(model);
        model.addAttribute("history", historyRepo.findAll());

        return "history";
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

    @GetMapping("/clear-history")
    public String clearHistory(Model model) {
        commnModel(model);
        historyRepo.deleteAll();
        return "redirect:/";
    }

    @GetMapping("/clear-prod")
    public String clearProd(Model model) {
        commnModel(model);
        productAnimalRepo.deleteAll();
        return "redirect:/";
    }

    @PostMapping("/clear")
    public String clear(Model model, @ModelAttribute PurchaseHistory purchaseHistory) {
        commnModel(model);
        PurchaseHistory purchase = new PurchaseHistory();
        purchase.setDate(new Date());
        purchase.setCart(cart.entrySet().stream()
                .map(longIntegerEntry -> productAnimalRepo.findById(longIntegerEntry.getKey())
                .orElseThrow().getName() + ": " + longIntegerEntry.getValue())
                .collect(Collectors.joining(", ")));
        historyRepo.save(purchase);
        cart.clear();
        return "redirect:/cart";
    }

    private void commnModel(Model model) {
        model.addAttribute("products", productAnimalRepo.findAll());
        model.addAttribute("cart", cart);
    }
}
