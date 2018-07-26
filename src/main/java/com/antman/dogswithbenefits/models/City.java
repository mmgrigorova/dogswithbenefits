package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryiD")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    public City(){

    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
