package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DogRestController {
    private DogService service;

    @Autowired
    public DogRestController(DogService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Dog> getAllDogs(){
        return service.getAllDogs();
    }


}
