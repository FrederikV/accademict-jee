package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class FlightRepositoryBean implements FlightRepositoryRemote {

    @PersistenceContext
    EntityManager em;
    @Override
    public Flight save(Flight flight) {
        em.persist(flight);
        return flight;
    }

    @Override
    public Flight findById(Long id) {
        return em.find(Flight.class,id);
    }

    @Override
    public List<Flight> findAll() {
        return em.createQuery("select f from Flight f", Flight.class).getResultList();
    }
}
