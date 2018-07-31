package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dogs")
public class DogWebController {
    private DogService service;

    @Autowired
    public DogWebController(DogService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ModelAndView listDogs(){
        ModelAndView mav = new ModelAndView("dogs");
        mav.addObject("title", "Our Dogs");
        mav.addObject("dogs", service.getAllDogs());
        return mav;
    }
}
