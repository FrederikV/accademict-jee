package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Flight;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FlightRepositoryRemote {
    Flight save(Flight flight);
    Flight findById(Long id);
    List<Flight> findAll();
}

