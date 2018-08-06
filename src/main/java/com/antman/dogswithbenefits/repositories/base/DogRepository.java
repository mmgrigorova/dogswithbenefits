package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Dog;

import java.util.List;

public interface DogRepository {
    List<Dog> getAllDogs();

    List<Dog> getPageOfDogs(int startPosition, int rowsCount);

    int getAllDogsCount();

    void addDog(Dog dog);

    Dog findById(int id);

    boolean update(Dog updateDog);

    boolean delete(Dog deleteDog);

}
