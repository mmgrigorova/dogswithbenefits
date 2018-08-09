package com.antman.dogswithbenefits.services;

import com.antman.dogswithbenefits.models.Breed;
import com.antman.dogswithbenefits.models.Dog;
import com.antman.dogswithbenefits.models.User;
import com.antman.dogswithbenefits.repositories.base.BreedRepository;
import com.antman.dogswithbenefits.repositories.base.DogRepository;
import com.antman.dogswithbenefits.repositories.base.PhotoRepository;
import com.antman.dogswithbenefits.services.base.DogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DogServiceImpl_Tests {
    @Mock
    private DogRepository mockDogRepository;
    @Mock
    private BreedRepository mockBreedRepository;
    @Mock
    private PhotoRepository mockPhotoRepository;

    private DogService dogService;

    @Test
    public void getDogPagesCount_whenDogCountIsLessThanRecordsPerPage_ReturnOnePage() {
        //arrange
        dogService = new DogServiceImpl(mockDogRepository, mockPhotoRepository, mockBreedRepository);
        int dogsPerPage = DogServiceImpl.getResultsPerPage();
        int dogCount = dogsPerPage - 5;

        Mockito.when(mockDogRepository.getAllDogsCount())
                .thenReturn(dogCount);

        //act
        int pages = dogService.getDogPagesCount();

        //assert
        Assert.assertEquals(pages, 1);
    }

    @Test
    public void getDogPagesCount_WhenDogCountIsTwiceThanRecordsPerPage_ThenTwoPages() {
        //arrange
        dogService = new DogServiceImpl(mockDogRepository, mockPhotoRepository, mockBreedRepository);
        int dogsPerPage = DogServiceImpl.getResultsPerPage();
        int dogCount = dogsPerPage * 2;

        Mockito.when(mockDogRepository.getAllDogsCount())
                .thenReturn(dogCount);

        //act
        int pages = dogService.getDogPagesCount();

        //assert
        Assert.assertEquals(pages, 2);
    }

    @Test
    public void getDogPagesCount_WhenDogCountIsBetweenTwoAndThreeTimesBiggerThanRecordsPerPage_ThenThreePages() {
        //arrange
        dogService = new DogServiceImpl(mockDogRepository, mockPhotoRepository, mockBreedRepository);
        int dogsPerPage = DogServiceImpl.getResultsPerPage();
        int dogCount = (dogsPerPage * 2) + 5;

        Mockito.when(mockDogRepository.getAllDogsCount())
                .thenReturn(dogCount);

        //act
        int pages = dogService.getDogPagesCount();

        //assert
        Assert.assertEquals(pages, 3);
    }

    private List<Dog> setupDogList(int dogsPerPage) {
        List<Dog> dogs = new ArrayList<>();
        User user = new User();
        user.setUserId(0);
        Breed breed = new Breed();
        breed.setId(1);
        Breed secondaryBreed = new Breed();
        breed.setId(2);
        int dogsToExtractFromDogsPerPage = 5;
        int testDogCount = dogsPerPage - dogsToExtractFromDogsPerPage;
        for (int i = 0; i < testDogCount; i++) {
            String dogName = "Dog" + i;
            Dog dog = new Dog(user, dogName, 'm', breed, secondaryBreed, i, 10 + 1, "Test dog");
            dogs.add(dog);
        }

        return dogs;
    }
}
