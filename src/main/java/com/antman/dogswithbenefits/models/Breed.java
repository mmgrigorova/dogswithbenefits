package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "breeds")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breedid")
    private int id;

    @Column(name = "breedname")
    private int name;

//    @OneToMany(mappedBy = "breed",
//            targetEntity = Dog.class,
//            cascade = CascadeType.ALL)
//    private List<Dog> dogs = new ArrayList<>();

//    @OneToMany(mappedBy = "secondaryBreed")
//    private List<Dog> dogSecondary = new ArrayList<>();

    public Breed() {
    }

    public Breed(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
//
//    public List<Dog> getDogs() {
//        return dogs;
//    }
//
//    public void setDogs(List<Dog> dogs) {
//        this.dogs = dogs;
//    }
}
