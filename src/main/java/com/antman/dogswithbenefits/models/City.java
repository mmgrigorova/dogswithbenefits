package com.antman.dogswithbenefits.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;

    @Column(name = "cityname")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
