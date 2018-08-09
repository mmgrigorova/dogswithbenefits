package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceImpl_Tests {
    @Mock
    private DogRepository dogRepository;

    private DogService dogService;
    private List<Dog> dogs;

//    @Before
//    private void prepareListDog(){
//        dogs = new ArrayList<>();
//        dogService = new DogServiceImpl(dogRepository);
//        when(dogRepository.addDog(any(Dog.class)))
//                .then(dogs.add(any(Dog.class)));
//    }

    //TODO Research how to validated the parameter that is passed to a method (to the repository.add method)
 }
