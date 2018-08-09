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
    private static final int RESULTS_PER_PAGE = 24;

    private final DogRepository repository;
    private final PhotoRepository photoRepository;
    private final BreedRepository breedRepository;

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
        // We are passing page 1, but we need page 0 as response
        int offsetPageNumber = pageNumber - 1;
        return repository.getPageOfDogs(offsetPageNumber, RESULTS_PER_PAGE);
    }

    @Override
    public int getDogPagesCount() {
        int pages = repository.getAllDogsCount() / RESULTS_PER_PAGE;
        int dogsPerPageCalculationHelper = repository.getAllDogsCount() % RESULTS_PER_PAGE;
        boolean needExtraDisplayOddRemainingDogs = dogsPerPageCalculationHelper > 0 || dogsPerPageCalculationHelper < RESULTS_PER_PAGE;
        if (needExtraDisplayOddRemainingDogs) {
            pages += 1;
        }

        return pages;
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
