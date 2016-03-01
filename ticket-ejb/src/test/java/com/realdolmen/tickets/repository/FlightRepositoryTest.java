package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.DomesticFlight;
import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;
import com.realdolmen.tickets.domain.Flight;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
public class FlightRepositoryTest {

    private static FlightRepositoryBean fr;
    private static EntityManagerFactory emf;
    private EntityTransaction transaction;

    @BeforeClass
    public static void setupBeforeClass() {
        emf = Persistence.createEntityManagerFactory("Test");
        fr = new FlightRepositoryBean();
    }

    @Before
    public void setup() {
        fr.em = emf.createEntityManager();
        transaction = fr.em.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() {
        transaction.rollback();
        fr.em.close();
    }

    @AfterClass
    public static void teardownAfterClass() {
        emf.close();
    }

    @Test
    public void shouldSaveAFlight() {
        Flight flight = new DomesticFlight();

        assertNull("Flight ID is supposed to be null before saving", flight.getId());
        fr.save(flight);
        fr.em.flush();
        assertNotNull("Employee ID is not supposed to be null after saving", flight.getId());
    }


}
