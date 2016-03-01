package com.realdolmen.tickets.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by FVTAZ67 on 22/02/2016.
 */
@Entity
public class Plane {
    @Id
    private Long id;
    private String type;
    //private List<Flight> flights;
}
