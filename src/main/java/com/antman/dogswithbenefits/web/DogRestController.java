package com.antman.dogswithbenefits.web;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Dog> getAllDogs() {
        return service.getAllDogs();
    }

    @GetMapping("/{dogId}")
    public Dog getDog(@PathVariable(name = "dogId") int dogId) {
        return service.fingById(dogId);
    }

    @PostMapping("/add")
    public void addDog(@RequestBody Dog dog) {
        service.addDog(dog);
    }

    @PutMapping("/update")
    public Dog updateDog(@RequestBody Dog dog) {
        return service.update(dog);
    }

    @GetMapping("/photos/{dogId}")
    public List<Photo> getDogPhotos(@PathVariable(name = "dogId") int dogId) {
        Dog dog = null;
        List<Photo> photos;

        dog = service.fingById(dogId);
        if (dog == null) {
            System.out.println("No dog with Id = " + dogId + " exists.");
            return null;
        }
        photos = service.getDogPhotos(dog);

        return photos;
    }
}
