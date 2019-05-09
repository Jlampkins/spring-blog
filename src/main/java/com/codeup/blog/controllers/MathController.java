package com.codeup.blog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addMath(@PathVariable int num1, @PathVariable int num2){
        return "The number is: " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subMath(@PathVariable int num1, @PathVariable int num2){
        return "The number is: " + (num2 - num1);
    }

    @GetMapping("/multiple/{num1}/and/{num2}")
    @ResponseBody
    public String multiMath(@PathVariable int num1, @PathVariable int num2){
        return "The number is: " + (num1 * num2);
    }

    @GetMapping("divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideMath(@PathVariable int num1, @PathVariable int num2){
        return "The number is: " + (num1 / num2);
    }




}
