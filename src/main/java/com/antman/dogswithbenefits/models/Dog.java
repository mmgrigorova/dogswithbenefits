package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dogid")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "ownerid")
    private User owner;

    @Column(name = "name")
    @Size(min = 3,max = 13,message = "Name field is required")
    private String name;

    @Column(name = "gender")
    private char gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breedid")
    private Breed breed;

    @ManyToOne
    @JoinColumn(name = "secBreedid")
    private Breed secondaryBreed;

    @Column(name = "age")
    @Min(value = 0, message = "Age should not be less than 0")
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;

    @Column(name = "weight")
    @Min(value = 0, message = "Weight should not be less than 0")
    private int weight;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "dog", cascade = CascadeType.ALL)
    private List<Photo> photos;

    public Dog() {
    }

    public Dog(User owner, String name, char gender, Breed breed, Breed secondaryBreed, int age, int weight, String description) {
        this.owner = owner;
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.secondaryBreed = secondaryBreed;
        this.age = age;
        this.weight = weight;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Breed getSecondaryBreed() {
        return secondaryBreed;
    }

    public void setSecondaryBreed(Breed secondaryBreed) {
        this.secondaryBreed = secondaryBreed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Photo getPhoto() {
        if (photos == null || photos.isEmpty()){
            return null;
        }
        return photos.get(0);
    }
}
