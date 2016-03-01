package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by FVTAZ67 on 22/02/2016.
 */
@Remote
public interface TicketRepositoryRemote {
        Ticket save(Ticket ticket);
        Ticket findById(Long id);
    Ticket update(Ticket ticket);
    void delete(Ticket ticket);
        List<Ticket> findAll();
    }
