package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
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

    @PostMapping("/add")
    public void addDog(@RequestBody Dog dog){
        service.addDog(dog);
    }

    @PutMapping("/update")
    public Dog updateDog(@RequestBody Dog dog){
        return service.update(dog);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDog(@PathVariable("id") int dogId){
        service.delete(dogId);
    }

    @GetMapping("/{id}")
    public Dog fingById(@PathVariable("id") int id){
        return service.fingById(id);
    }

}
