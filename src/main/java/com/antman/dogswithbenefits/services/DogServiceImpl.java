package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.BreedRepository;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private DogRepository dogRepository;
    private BreedRepository breedRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository, BreedRepository breedRepository) {
        this.dogRepository = dogRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public void addDog(Dog dog) {
        if (dog.getSecondaryBreed() == null || dog.getSecondaryBreed().getId() == 0) {
            dog.setSecondaryBreed(null);
        }
        dogRepository.save(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        Iterable<Dog> allDogs = dogRepository.findAll();
        return Utilities.makeCollection(allDogs);
    }

    @Override
    public List<Breed> getBreeds() {
        Iterable<Breed> allBreeds = breedRepository.findAll();
        return Utilities.makeCollection(allBreeds);
    }
}
