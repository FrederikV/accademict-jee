package com.realdolmen.tickets.domain;

import javax.persistence.Embeddable;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Embeddable
public class Address {
    private String street1;
    private String street2;
    private String city;
    private String zipCode;
    private String country;

    public Address() {
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

