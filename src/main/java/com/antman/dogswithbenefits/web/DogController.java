package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    private DogService service;

    @Autowired
    public DogController(DogService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllDogs(Model model){
        model.addAttribute("dogs", service.getAllDogs());
        return "listDog";
    }
}
//this is a test change