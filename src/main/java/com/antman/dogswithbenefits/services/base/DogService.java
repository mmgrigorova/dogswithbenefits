package com.antman.dogswithbenefits.services.base;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;

import java.util.List;

public interface DogService {
    void addDog(Dog dog);
    List<Dog> getAllDogs();
    Dog fingById(int id);
    Dog update(Dog dog);
    void addPhoto(Photo photo);
    List<Photo> getDogPhotos(Dog dog);
    List<Breed> getBreeds();

}
