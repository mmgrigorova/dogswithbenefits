package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Dog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository {
    List<Dog> getAllDogs();
}
