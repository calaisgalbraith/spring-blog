package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showRollForm() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable int n, Model model) {
        Random random = new Random();
        int rand = random.nextInt((6 - 1) + 1) + 1;

        model.addAttribute("guess", n);
        model.addAttribute("roll", rand);
        return "roll-answer";
    }


}
