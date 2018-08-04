package com.antman.dogswithbenefits.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photoid")
    private int id;

    @ManyToOne
    @JoinColumn(name = "dogid")
    @JsonIgnore
    private Dog dog;

    @Column(name = "photo")
    private String path;

    public Photo() {
    }

    public Photo(Dog dog, String path) {
        this.dog = dog;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
