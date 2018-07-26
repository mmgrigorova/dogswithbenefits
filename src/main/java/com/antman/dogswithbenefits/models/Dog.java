package com.antman.dogswithbenefits.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dogid")
    private int id;

    @Column(name = "ownerid")
    private int userid;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private char gender;

//    @ManyToOne(fetch=FetchType.EAGER)
//    @JoinColumn(name = "breedid")
//    private Breed breed;

//    @ManyToOne
//    @JoinColumn(name = "secBreedid")
//    private Breed secondaryBreed;

    @Column(name = "age")
    private int age;

    @Column(name = "weight")
    private int weight;

    @Column(name = "description")
    private String description;

    public Dog() {
    }

    public Dog(int userid, String name, char gender, Breed breed, int age, int weight, String description) {
        this.userid = userid;
        this.name = name;
        this.gender = gender;
//        this.breed = breed;
//        this.secondaryBreed = secondaryBreed;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

//    public Breed getBreed() {
//        return breed;
//    }
//
//    public void setBreed(Breed breed) {
//        this.breed = breed;
//    }
//
//    public Breed getSecondaryBreed() {
//        return secondaryBreed;
//    }
//
//    public void setSecondaryBreed(Breed secondaryBreed) {
//        this.secondaryBreed = secondaryBreed;
//    }

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
}
