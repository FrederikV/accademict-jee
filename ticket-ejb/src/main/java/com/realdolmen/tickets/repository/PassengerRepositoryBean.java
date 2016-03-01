package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PassengerRepositoryBean implements PassengerRepositoryRemote {

    @PersistenceContext
    EntityManager em;

    @Override
    public Passenger save(Passenger passenger) {
        em.persist(passenger);
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        em.persist(passenger);
        return passenger;
    }

    @Override
    public void delete(Passenger passenger) {
       em.remove(passenger);
    }

    @Override
    public Passenger findById(Long id) {
        return em.find(Passenger.class,id);
    }

    @Override
    public List<Passenger> findAll() {
        return em.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    @Override
    public List<String> findAllLastNames() {
        return em.createNamedQuery(Passenger.FIND_ALL_LASTNAMES).getResultList();
    }

    @Override
    public Long totalFrequentFlyerMiles() {
        em.createQuery("select SUM(p.frequentFlyerMiles) from Passenger p").getSingleResult();
        return null;
    }

    @Override
    public List<Ticket> findTicketsByPassengerId(Long id) {
        return em.createQuery("select t from Ticket t where t.passenger.id=:id").setParameter("id",id).getResultList();
    }
}
