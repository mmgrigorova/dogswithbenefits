package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.Photo;

import java.util.List;

public interface DogRepository {
    List<Dog> getAllDogs();

    List<Dog> getPageOfDogs(int startPosition, int rowsCount);

    int getAllDogsCount();

    void addDog(Dog dog);

    Dog findById(int id);

    boolean update(Dog updateDog);

    boolean delete(Dog deleteDog);

    void addPhoto(Photo photo);

    List<Breed> getBreeds();
}
