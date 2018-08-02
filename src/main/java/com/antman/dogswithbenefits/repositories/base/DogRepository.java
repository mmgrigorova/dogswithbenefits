package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;

import java.util.List;

public interface DogRepository {
    List<Dog> getAllDogs();
    void addDog(Dog dog);
    Dog findById(int id);
    void update(Dog updateDog);
    void addPhoto(Photo photo);
    List<Photo> getDogPhotos(Dog dog);
    List<Breed> getBreeds();
}
