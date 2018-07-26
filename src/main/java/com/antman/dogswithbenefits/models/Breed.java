package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "breeds")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breedid")
    private int id;

    @Column(name = "breedname")
    private String name;

    @OneToMany(mappedBy = "breed")
    private List<Dog> dogs;

    @OneToMany(mappedBy = "secondaryBreed")
    private List<Dog> dogsSecondary;

    public Breed() {
    }

    public Breed(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Dog> getDogsSecondary() {
        return dogsSecondary;
    }

    public void setDogsSecondary(List<Dog> dogsSecondary) {
        this.dogsSecondary = dogsSecondary;
    }
}
