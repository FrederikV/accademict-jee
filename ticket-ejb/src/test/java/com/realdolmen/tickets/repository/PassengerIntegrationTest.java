package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.PassengerType;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PassengerIntegrationTest {
    private static Context context;

    @BeforeClass
    public static void setupBeforeClass() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        properties.put(Context.SECURITY_PRINCIPAL, "administrator");
        properties.put(Context.SECURITY_CREDENTIALS, "Azerty123!");
        context = new InitialContext(properties);
    }
    @Test
    public void testPassengerServiceCanBeAccessedRemotely() throws Exception {
        PassengerRepositoryRemote repository = (PassengerRepositoryRemote) context.lookup("ticket-ear-1.0/ticket-ejb/PassengerRepositoryBean!com.realdolmen.tickets.repository.PassengerRepositoryRemote");
        System.out.println(repository);
        for (Passenger p : repository.findAll()) {
            System.out.println(p.getFirstName() + " " + p.getLastName());
        }
    }

    @Test
    public void test2() throws Exception {
        PassengerRepositoryRemote repository = (PassengerRepositoryRemote) context.lookup("ticket-ear-1.0/ticket-ejb/PassengerRepositoryBean!com.realdolmen.tickets.repository.PassengerRepositoryRemote");

    }
    }
