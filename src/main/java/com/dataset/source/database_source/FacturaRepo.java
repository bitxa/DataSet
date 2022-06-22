package com.dataset.source.database_source;

import com.dataset.clases.Factura;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.ArrayList;

public class FacturaRepo {
    ArrayList<Factura> facturas;

    StandardServiceRegistry standardServiceRegistry;

    Metadata meta;

    SessionFactory factory;
    Session session;
    Transaction transaction;

    public FacturaRepo() {
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
                .build();
        meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        transaction = session.beginTransaction();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FacturaRepo clienteRepo = new FacturaRepo();
        //(String name, String bornDate, String address, String phone, String email)
        clienteRepo.updteBill( new Factura(1,2, "01/01/2022",
                "Tomates"));
    }
    public boolean addBill(Factura factura) throws IOException, ClassNotFoundException {
        session.save(factura);
        transaction.commit();
        //factory.close();
        session.close();
        return true;
    }

    public ArrayList<Factura> getBills() throws IOException, ClassNotFoundException {
        facturas = new ArrayList<>();
        facturas = (ArrayList<Factura>) session.createQuery("from Factura").list();
        return facturas;
    }

    public boolean removeBillById(int billNum) throws IOException, ClassNotFoundException {
        session.createQuery("delete Factura where factura_num = :billNum").setParameter("billNum",
                        billNum)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public void updteBill(Factura bill) throws IOException, ClassNotFoundException {
        session.update(bill);
        transaction.commit();
        session.close();
    }

    public boolean addBills(ArrayList<Factura> facturas) throws IOException, ClassNotFoundException {
        for (Factura factura : facturas) {
            addBill(factura);
        }
        return true;
    }


}
