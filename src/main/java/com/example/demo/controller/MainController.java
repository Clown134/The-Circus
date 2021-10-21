package com.example.demo.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class MainController {

    @GetMapping("/")
    public String CarouselTemplateBootstrapv5(Model model, @RequestParam(required = false) String string) {
        model.addAttribute("message", string);
        return "index";
    }
}
