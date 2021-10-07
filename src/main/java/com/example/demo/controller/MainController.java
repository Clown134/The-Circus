package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/")
    public String CarouselTemplateBootstrapv5(Model model, @RequestParam(required = false) String string) {
        model.addAttribute("ilia", string);
        return "index";
    }

}
