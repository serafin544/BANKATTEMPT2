package com.example.MacFin.model;


import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ADDRESS_ID")
    private Long id;

    @Column(name="STREET_NUMBER")
    private String streetNumber;

    @Column(name="STREET_NAME")
    private String streetName;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP")
    private String zip;

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String street_number) {
        this.streetNumber = street_number;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String street_name) {
        this.streetName = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}



