package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @Column(name = "countryid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;

    @Column(name = "countryname")
    private String countryName;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country(){

    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
