package com.realdolmen.tickets.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by FVTAZ67 on 22/02/2016.
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@DiscriminatorValue("IF")
public class InternationalFlight extends Flight {

    private boolean blacklisted;
    private String regulations;
}
