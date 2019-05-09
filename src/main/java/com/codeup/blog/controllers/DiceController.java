package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
public class DiceController {
    @GetMapping("/roll-dice")
    public String chooseNum(Model viewModel) {
        List<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        viewModel.addAttribute("numbers", numbers);
        return "dice"; //returning the home file from the template folder
    }

    @GetMapping("/roll-dice/{n}")
    public String rollDice(@PathVariable String n, Model viewModel ) {
        Random random = new Random();

// generate a random integer from 1 to 6.
        Integer ranNum = random.nextInt(6) + 1;
        String ranStr = String.valueOf(ranNum);

        viewModel.addAttribute("ranNum", ranStr);
        viewModel.addAttribute("n", n);

        if(n.equals(ranStr)){
            viewModel.addAttribute("success", "You did it!");
            viewModel.addAttribute("restart", true);
        }else if(!n.equals(ranStr)){
            viewModel.addAttribute("success", "Try again!");
            viewModel.addAttribute("restart", true);
        }

        return "dice";
    }

}
