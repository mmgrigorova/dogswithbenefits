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

    private final DogRepository dogRepository;
    private final PhotoRepository photoRepository;
    private final BreedRepository breedRepository;

    @Autowired
    public DogServiceImpl(DogRepository repository, PhotoRepository photoRepository, BreedRepository breedRepository) {
        this.dogRepository = repository;
        this.photoRepository = photoRepository;
        this.breedRepository = breedRepository;
    }

    @Override
    public void addDog(Dog dog) {
        if (dog.getSecondaryBreed() == null || dog.getSecondaryBreed().getId() == 0) {
            dog.setSecondaryBreed(null);
        }
        dogRepository.addDog(dog);
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.getAllDogs();
    }

    @Override
    public List<Dog> getPageOfDogs(int pageNumber) {
        // We are passing page 1, but we need page 0 as response
        int offsetPageNumber = pageNumber - 1;
        return dogRepository.getPageOfDogs(offsetPageNumber, RESULTS_PER_PAGE);
    }

    @Override
    public int getDogPagesCount() {
        int allDogsCount = dogRepository.getAllDogsCount();
        int pages = allDogsCount / RESULTS_PER_PAGE;
        int dogsPerPageCalculationHelper = allDogsCount % RESULTS_PER_PAGE;
        boolean needExtraDisplayOddRemainingDogs = dogsPerPageCalculationHelper > 0;
        if (needExtraDisplayOddRemainingDogs) {
            pages += 1;
        }

        return pages;
    }

    @Override
    public Dog fingById(int id) {
        return dogRepository.findById(id);
    }

    @Override
    public Dog update(Dog dog) {
        dogRepository.update(dog);
        Dog result = fingById(dog.getId());
        return result;
    }

    @Override
    public boolean delete(int dogId) {
        Dog dog = dogRepository.findById(dogId);
        return dogRepository.delete(dog);
    }

    @Override
    public void addPhoto(Photo photo) {
        photoRepository.addPhoto(photo);
    }

    @Override
    public List<Breed> getBreeds() {
        return breedRepository.getBreeds();
    }

    public static int getResultsPerPage() {
        return RESULTS_PER_PAGE;
    }
}
