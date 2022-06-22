package com.dataset.source.database_source;

import com.dataset.clases.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.util.ArrayList;

public class ClienteRepo {
    ArrayList<Cliente> customers;

    StandardServiceRegistry standardServiceRegistry;

    Metadata meta;

    SessionFactory factory;
    Session session;
    Transaction transaction;

    public ClienteRepo() {
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build();
        meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        transaction = session.beginTransaction();
    }


   public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClienteRepo clienteRepo = new ClienteRepo();
        //(String name, String bornDate, String address, String phone, String email)
       clienteRepo.updateCustomer( new Cliente(2,"Jorge", "01/01/2000", "Calle 1",
               "123456789", "joelsebastianromero14@gmail.com"));
    }
    public boolean addCustomer(Cliente customer) throws IOException, ClassNotFoundException {
        session.save(customer);
        transaction.commit();
        //factory.close();
        session.close();
        return true;
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException {
        customers = new ArrayList<>();
        customers = (ArrayList<Cliente>) session.createQuery("from Cliente").list();
        return customers;
    }

    public boolean removeCustomerById(int id) throws IOException, ClassNotFoundException {
        session.createQuery("delete Cliente where id = :id").setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public boolean updateCustomer(Cliente newCustomer) throws IOException, ClassNotFoundException {
        session.update(newCustomer);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean addCustomers(ArrayList<Cliente> customers) throws IOException, ClassNotFoundException {
        for (Cliente customer : customers) {
            addCustomer(customer);
        }
        return true;
    }
}
