package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;
import com.antman.dogswithbenefits.repositories.base.BreedRepository;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.repositories.base.PhotoRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {
    private static final int RESULTS_PER_PAGE = 100;

    private DogRepository repository;
    private PhotoRepository photoRepository;
    private BreedRepository breedRepository;

    @Autowired
    public DogServiceImpl(DogRepository repository, PhotoRepository photoRepository, BreedRepository breedRepository) {
        this.repository = repository;
        this.photoRepository = photoRepository;
        this.breedRepository = breedRepository;
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
    public List<Dog> getPageOfDogs(int pageNumber) {
        return repository.getPageOfDogs(pageNumber, RESULTS_PER_PAGE);
    }

    public int getPages() {
        return repository.getAllDogsCount();
    }

    @Override
    public Dog fingById(int id) {
        return repository.findById(id);
    }

    @Override
    public Dog update(Dog dog) {
        repository.update(dog);
        Dog result = fingById(dog.getId());
        return result;
    }

    @Override
    public boolean delete(int dogId) {
        Dog dog = repository.findById(dogId);
        return repository.delete(dog);
    }

    @Override
    public void addPhoto(Photo photo) {
        photoRepository.addPhoto(photo);
    }

    @Override
    public List<Breed> getBreeds() {
        return breedRepository.getBreeds();
    }
}
