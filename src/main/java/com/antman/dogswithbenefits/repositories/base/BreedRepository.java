package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Breed;

import java.util.List;

public interface BreedRepository {
    List<Breed> getBreeds();
}
