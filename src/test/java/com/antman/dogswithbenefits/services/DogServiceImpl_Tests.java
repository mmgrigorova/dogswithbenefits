package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.repositories.base.BreedRepository;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.repositories.base.PhotoRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceImpl_Tests {
    @Mock
    private DogRepository dogRepository;
    @Mock
    private BreedRepository breedRepository;
    @Mock
    private PhotoRepository photoRepository;

    private DogService dogService;
    private List<Dog>  dogs = new ArrayList<>();;

    @Before
    public void prepareListDog(){
        dogService = new DogServiceImpl(dogRepository, photoRepository, breedRepository);
    }

//    @Test
//    public void addDog_whenSecondaryBreedIsZero_SetNullInDogObject(){
//        //arrange
//        User user = new User();
//        user.setUserId(0);
//        Breed breed = new Breed();
//        breed.setId(1);
//        Breed secondaryBreed = new Breed();
//        breed.setId(0);
//        Dog dog = new Dog(user,"Dog1", 'm', breed, secondaryBreed, 5, 10, "Test dog with zero secondary breed" );
//
//        // act
////        dogService.addDog(dog);
//
//        // assert
//        ArgumentCaptor<Dog> captur = ArgumentCaptor.forClass(Dog.class);
//        dogService.addDog(captur.capture());
//        assertThat(captur.getValue().getSecondaryBreed().getId(),isNull());
//    }
 }
