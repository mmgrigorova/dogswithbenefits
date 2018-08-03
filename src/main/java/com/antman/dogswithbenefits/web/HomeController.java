package com.antman.dogswithbenefits.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HomeController {
    @GetMapping("")
    public String indexHandler(Model model){
        model.addAttribute("title", "Dogs with Benefits");
        return "index";
    }
}
