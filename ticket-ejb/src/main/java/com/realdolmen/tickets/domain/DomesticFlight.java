package com.realdolmen.tickets.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@DiscriminatorValue("DF")
public class DomesticFlight extends Flight {
    private String airlineCompany;
    @ElementCollection()
    private List<String> refs;

    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getRefs() {
        return refs;
    }

    public void setRefs(List refs) {
        this.refs = refs;
    }
}
