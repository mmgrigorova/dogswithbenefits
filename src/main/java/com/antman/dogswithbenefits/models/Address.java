package com.antman.dogswithbenefits.models;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @Column(name = "streetaddress")
    private String streetAddress;

    @Column(name = "postalcode")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "cityid")
    private City city;

    @OneToOne(mappedBy = "address")
    private User user;



    public Address(){

    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPosctCode() {
        return postalCode;
    }

    public void setPosctCode(String posctCode) {
        this.postalCode = posctCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
