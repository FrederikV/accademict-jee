package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by FVTAZ67 on 22/02/2016.
 */
@Stateless
@LocalBean
public class TicketRepositoryBean implements TicketRepositoryRemote {
    @PersistenceContext
    EntityManager em;

    @Override
    public Ticket save(Ticket ticket) {
        em.persist(ticket);
        return ticket;
    }

    @Override
    public Ticket findById(Long id) {
        return em.find(Ticket.class,id);
    }

    @Override
    public List<Ticket> findAll() {
        return em.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }

    @Override
    public Ticket update(Ticket ticket) {
        em.persist(ticket);
        return ticket;
    }

    @Override
    public void delete(Ticket ticket) {
        em.remove(ticket);
    }
}
