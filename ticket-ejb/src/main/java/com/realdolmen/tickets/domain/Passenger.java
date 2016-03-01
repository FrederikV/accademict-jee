package com.realdolmen.tickets.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQueries({
        @NamedQuery( name=Passenger.FIND_ALL_LASTNAMES, query="select p.lastName from Passenger p")
})
public class Passenger implements Serializable{

    public static final String FIND_ALL_LASTNAMES = "Passenger.findAllLastNames";

    private Long id;
    private String firstName;
    private String lastName;
    private String ssn;
    private Integer frequentFlyerMiles;
    private Date dateOfBirth;
    private Integer age;
    private PassengerType passengerType;
    private Date lastFlight;
    private Address address;
    private List<Ticket> tickets;

    private Integer version;
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    protected Passenger() {
    }

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Transient
    public Integer getAge() {
        return age;
    }

    @Enumerated(EnumType.STRING)
    public PassengerType getPassengerType() {
        return passengerType;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastFlight() {
        return lastFlight;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }


    @Column(length=50)
    public String getFirstName() {
        return firstName;
    }


    @Column(length=50)
    public String getLastName() {
        return lastName;
    }


    @Column(nullable = false,updatable = false)
    public String getSsn() {
        return ssn;
    }

    public Integer getFrequentFlyerMiles() {
        return frequentFlyerMiles;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    @OneToMany(mappedBy ="passenger")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private void setId(Long id) {
        this.id = id;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFrequentFlyerMiles(Integer frequentFlyerMiles) {
        this.frequentFlyerMiles = frequentFlyerMiles;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", frequentFlyerMiles='" + frequentFlyerMiles + '\'' +
                '}';
    }
}
