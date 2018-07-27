package com.antman.dogswithbenefits.services;

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
        repository.addDog(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return repository.getAllDogs();
    }
}
