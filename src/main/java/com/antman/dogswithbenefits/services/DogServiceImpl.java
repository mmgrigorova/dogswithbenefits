package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
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
    public Dog fingById(int id) {
        Dog dog;
        try {
           dog = repository.findById(id);
        } catch (NullPointerException e){
            System.out.println("There is no dog with id " + id);
            return null;
        }
        return dog;
    }

    @Override
    public Dog update(Dog dog) {
        repository.update(dog);
        Dog result = fingById(dog.getId());
        return result;
    }

    @Override
    public void addPhoto(Photo photo) {
        repository.addPhoto(photo);
    }

    @Override
    public List<Photo> getDogPhotos(Dog dog) {
        return repository.getDogPhotos(dog);
    }

    @Override
    public List<Breed> getBreeds() {
        return repository.getBreeds();
    }
}
