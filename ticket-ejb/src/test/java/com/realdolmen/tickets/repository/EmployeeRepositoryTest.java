package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;
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
public class EmployeeRepositoryTest {

    private static EmployeeRepositoryBean er;
    private static EntityManagerFactory emf;
    private EntityTransaction transaction;

    @BeforeClass
    public static void setupBeforeClass() {
        emf = Persistence.createEntityManagerFactory("Test");
        er = new EmployeeRepositoryBean();
    }

    @Before
    public void setup() {
        er.em = emf.createEntityManager();
        transaction = er.em.getTransaction();
        transaction.begin();
    }

    @After
    public void tearDown() {
        transaction.rollback();
        er.em.close();
    }

    @AfterClass
    public static void teardownAfterClass() {
        emf.close();
    }

    @Test
    public void shouldSaveAnEmployee() {
        EmployeeId eid = new EmployeeId("eenssn","Vantroys");
        byte[] pic = null;
        Employee e = new Employee(eid, "Frederik",pic);

        assertNull("Employee ID is supposed to be null before saving", er.findById(eid));
        er.save(e);
        er.em.flush();
        assertNotNull("Employee ID is not supposed to be null after saving", er.findById(eid));
    }


}
