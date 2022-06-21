package com.dataset.source;

import com.dataset.clases.Cliente;

import java.io.*;
import java.util.ArrayList;

public class DatabaseSource {
    ArrayList<Cliente> customers;

    public boolean addCustomer(Cliente customer) throws IOException, ClassNotFoundException {

        return true;
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException {

        return customers;
    }

    public boolean removeCustomer(String id) throws IOException, ClassNotFoundException {

        return true;
    }

    public boolean updateCustomer(String id, Cliente newCustomer) throws IOException, ClassNotFoundException {


        return true;
    }

    public boolean addCustomers(ArrayList<Cliente> customers) throws IOException, ClassNotFoundException {

        return true;
    }

}
