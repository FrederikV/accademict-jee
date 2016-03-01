package com.realdolmen.tickets.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import static javax.persistence.FetchType.EAGER;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable{
    @EmbeddedId
    private EmployeeId id;
    private String firstName;
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    protected Employee() {
    }

    public Employee(EmployeeId id, String firstName, byte[] picture) {
        this.id = id;
        this.firstName = firstName;
        this.picture = picture;
    }

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
