package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    public int i = 0;

    @GetMapping("/cart")
    public String cartMain(Model model, @RequestParam(required = false)int id) {
        if (id==1){
            i++;
        }
        if (id==0){
            i--;
        }
        model.addAttribute("index",i);
        return "cart";
    }

}
