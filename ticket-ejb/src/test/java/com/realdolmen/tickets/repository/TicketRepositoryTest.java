package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.*;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
public class TicketRepositoryTest {

    private static TicketRepositoryBean tr;
    private static EntityManagerFactory emf;
    private EntityTransaction transaction;

    @BeforeClass
    public static void setupBeforeClass() {
        emf = Persistence.createEntityManagerFactory("Test");
        tr = new TicketRepositoryBean();
    }

    @Before
    public void setup() {
        tr.em = emf.createEntityManager();
        transaction = tr.em.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() {
        transaction.rollback();
        tr.em.close();
    }

    @AfterClass
    public static void teardownAfterClass() {
        emf.close();
    }

    @Test
    public void shouldSaveATicket() {
        Flight flight = new DomesticFlight();
        Ticket ticket = new Ticket(flight);

        assertNull("Ticket ID is supposed to be null before saving", ticket.getId());
        tr.em.persist(flight);
        assertNotNull("Flight has to have an ID after saving", flight.getId());
        tr.save(ticket);
        tr.em.flush();
        assertNotNull("Ticket ID is not supposed to be null after saving",ticket.getId());
    }

    @Test
    public void shouldDeleteATicket() {
        Ticket t = tr.findById(1L);
        assertNotNull(t);
        tr.delete(t);
        assertNull(tr.findById(1L));
    }

    @Test
    public void shouldReturnAllTickets() {
        List<Ticket> tickets =tr.findAll();
        assertNotNull(tickets);
        //assertEquals(2, tickets.size());
    }
    @Test
    public void shouldUpdateATicket() {
        Ticket ticket = tr.findById(1L);
        assertNotNull(ticket);
        ticket.setPrice(123.0);
        tr.update(ticket);
        ticket = tr.findById(1L);
        assertEquals(new Double(123.0), ticket.getPrice());
    }

}
