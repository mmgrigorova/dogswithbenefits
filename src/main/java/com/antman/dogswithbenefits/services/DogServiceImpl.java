package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private DogRepository repository;

    @Autowired
    public DogServiceImpl(DogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addDog(Dog dog) {
        if (dog.getSecondaryBreed() == null || dog.getSecondaryBreed().getId() == 0) {
            dog.setSecondaryBreed(null);
        }
        repository.addDog(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return repository.getAllDogs();
    }

    @Override
    public List<Breed> getBreeds() {
        return repository.getBreeds();
    }
}
