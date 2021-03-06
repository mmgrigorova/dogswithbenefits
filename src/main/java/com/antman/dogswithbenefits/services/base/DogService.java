package com.antman.dogswithbenefits.services.base;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;

import java.util.List;

public interface DogService {
    void addDog(Dog dog);
    List<Dog> getAllDogs();
    List<Dog> getPageOfDogs(int pageNumber);
    int getDogPagesCount();
    Dog fingById(int id);
    Dog update(Dog dog);
    boolean delete(int dogId);
    void addPhoto(Photo photo);
    List<Breed> getBreeds();
    List<Dog> searchFilter(String input, String choice);

}
