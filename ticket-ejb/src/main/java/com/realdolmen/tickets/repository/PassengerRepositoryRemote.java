package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
@Remote
public interface PassengerRepositoryRemote {
    Passenger save(Passenger passenger);
    Passenger update(Passenger passenger);
    void delete(Passenger passenger);
    Passenger findById(Long id);
    List<Passenger> findAll();
    List<String> findAllLastNames();
    Long totalFrequentFlyerMiles();
    List<Ticket> findTicketsByPassengerId(Long id);

}
