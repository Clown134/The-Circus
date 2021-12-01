package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    public static Integer count = 0;

    public List<ProdAnima> products = new ArrayList<>();

    {
        products.add(new ProdAnima(0,"https://sun9-33.userapi.com/impg/Dvwv94QDPgV67mY5kcfzqjOC0LC4WPr_QVtlIA/Oye0B08AWfM.jpg?size=500x500&quality=96&sign=88236c2f0c7c6f81d9a790937b7d086a&type=album","Арбуз в сделку не входит","Кот на арбузе"));
        products.add(new ProdAnima(0,"https://sun9-30.userapi.com/impg/5y7JYNiS10U4ZkQn0nqBs5UGc7uCAj5qONrvqQ/tRntNfvN4mw.jpg?size=500x500&quality=96&sign=39965f5eb54c88573ac163c3314ea5c0&type=album","Отдадим его в ваши руки очень неохотно","Потом узнаем"));
        products.add(new ProdAnima(0,"https://sun9-49.userapi.com/impg/kCBm6GvhaBx_7LM84UNEupaAW5kyjrfEGTeBnQ/lzUCJuXla8M.jpg?size=500x500&quality=96&sign=cfdc136b2c3281c59c582a572bea4972&type=album","Большая и с очками","Обезьяна"));
    }

    public List<ProdAnimaModal> CDG = new ArrayList<>();

    {
        CDG.add(new ProdAnimaModal("Полосатый кот-улыбака. С ним ваша жизнь станет ярче. Кот не оставит вас без внимания, в любое время вы сможете послушать от него забавные анекдоты.","https://sun9-33.userapi.com/impg/Dvwv94QDPgV67mY5kcfzqjOC0LC4WPr_QVtlIA/Oye0B08AWfM.jpg?size=500x500&quality=96&sign=88236c2f0c7c6f81d9a790937b7d086a&type=album","Любит рассказывать анекдоты.","Юморной котик"));
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("products", products);
        return "cart";
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String string) {
        model.addAttribute("products", products);
        model.addAttribute("CDG", CDG);
        return "index";
    }

    @PostMapping("/buy")
    public String buy(Model model, @RequestParam Integer id) {
        ProdAnima prodAnima = products.get(id);
        Integer previousValue = prodAnima.getNumberPurchases();
        prodAnima.setNumberPurchases(previousValue + 1);

        model.addAttribute("products", products);
        return "cart";
    }

    @PostMapping("/sell")
    public String sell(Model model, @RequestParam Integer id) {

        ProdAnima prodAnima = products.get(id);
        Integer previousValue = prodAnima.getNumberPurchases();
        prodAnima.setNumberPurchases(previousValue - 1);

        model.addAttribute("products", products);
        return "cart";
    }
}
