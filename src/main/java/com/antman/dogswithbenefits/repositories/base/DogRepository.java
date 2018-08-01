package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Integer> {
//    List<Dog> getAllDogs();
//    void addDog(Dog dog);
//    List<Breed> getBreeds();
}
