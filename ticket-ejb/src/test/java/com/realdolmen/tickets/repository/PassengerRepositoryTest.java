package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.PassengerType;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by FVTAZ67 on 19/02/2016.
 */
public class PassengerRepositoryTest {
    private static PassengerRepositoryBean pr;
    private static EntityManagerFactory emf;
    private EntityTransaction transaction;

    @BeforeClass
    public static void setupBeforeClass() {
        emf = Persistence.createEntityManagerFactory("Test");
        pr = new PassengerRepositoryBean();
    }

    @Before
    public void setup() {
        pr.em = emf.createEntityManager();
        transaction = pr.em.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() {
        transaction.rollback();
        pr.em.close();
    }

    @AfterClass
    public static void teardownAfterClass() {
        emf.close();
    }

    @Test
    public void shouldSaveAPassenger() {
      Passenger p = new Passenger("Frederik","Vantroys");
        p.setDateOfBirth(new Date());
        p.setPassengerType(PassengerType.OCCASIONAL);
        p.setSsn("ssn");

        assertNull("Passenger ID is supposed to be null before saving", p.getId());
        pr.save(p);
        pr.em.flush();
        assertNotNull("Passenger ID is not supposed to be null after saving", p.getId());
    }

    @Test
    public void shouldDeleteAPassenger() {
        Passenger p = pr.findById(1L);
        assertNotNull(p);
        pr.delete(p);
        assertNull(pr.findById(1L));
    }

    @Test
         public void shouldReturnAllPassengers() {
        List<Passenger> passengers = pr.findAll();
        assertNotNull(passengers);
        assertEquals(2, passengers.size());
    }

    @Test
    public void shouldReturnAPassenger() {
        Passenger p = pr.findById(1L);
        assertEquals(new Integer(1),p.getVersion());
        assertNotNull(p);
        assertEquals(new Long(1L), p.getId());
        assertEquals("Fred", p.getFirstName());
    }
    @Test
    public void shouldUpdateAPassenger() {
        Passenger p = pr.findById(2L);
        assertNotNull(p);
        assertEquals("Fred", p.getFirstName());
        assertEquals(new Integer(1),p.getVersion());
        p.setFirstName("yoenit");
        p=pr.update(p);
        pr.em.flush();
        assertEquals(new Integer(2),p.getVersion());
        assertEquals("yoenit", p.getFirstName());
    }

    @Test
    public  void shouldReturnLastnames() {
        List<String> lastNames = pr.findAllLastNames();
        assertEquals("Doe",lastNames.get(0));
        assertEquals("Doe2",lastNames.get(1));
    }

    @Test
    public  void shouldReturnSumOfMiles() {
        Long total = pr.totalFrequentFlyerMiles();
        assertNull(total);
    }
}
