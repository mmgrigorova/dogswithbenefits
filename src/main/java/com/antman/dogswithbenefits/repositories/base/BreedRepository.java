package com.antman.dogswithbenefits.repositories.base;

import com.antman.dogswithbenefits.models.Breed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends CrudRepository<Breed, Integer> {
}
