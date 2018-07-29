package com.antman.dogswithbenefits.services.base;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;

import java.util.List;

public interface DogService {
    void addDog(Dog dog);
    List<Dog> getAllDogs();
    List<Breed> getBreeds();

}
