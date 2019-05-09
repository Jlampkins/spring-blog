package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


//    @GetMapping("/")
//    @ResponseBody
//    public String showLanding(){
//        return "This is the landing page!";
//    }


        @GetMapping("/home")
        public String welcome() {
            return "home"; //returning the home file from the template folder
        }

    @GetMapping("/home/{name}")
    public String welcome(@PathVariable String name, Model viewModel) {
            List<String> names = new ArrayList<>();
            names.add("James");
            names.add("Bethany");
            names.add("Jeremey");
            names.add("Adrien");

            viewModel.addAttribute("names", names);
            if(name.equals("fer")){
                viewModel.addAttribute("admin", true);
            }
            viewModel.addAttribute("username", name.toUpperCase());
        return "home";
    }





}
