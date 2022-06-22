package com.dataset.logica;

import com.dataset.clases.Cliente;
import com.dataset.source.binary_source.ClienteBinaryFileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryFileLogic {
    Cliente customer;
    ClienteBinaryFileSource source;

    ArrayList<Cliente> customers = new ArrayList<>();

    public boolean addCustomer(Cliente customer) throws IOException, IOException, ClassNotFoundException {
        this.customer = customer;
        validateId();
        return source.addCustomer(customer);
    }

    public boolean removeCustomer(String id) throws IOException, ClassNotFoundException {
        return source.removeCustomer(id);
    }

    public boolean updateCustomer(String id, Cliente newCliente) throws IOException, ClassNotFoundException {
        this.customer = newCliente;
        validateId();
        return source.updateCustomer("1", newCliente);
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException {
        return source.getCustomers();
    }

    public boolean addCustomers(ArrayList<Cliente> customers) throws IOException, ClassNotFoundException {
        return source.addCustomers(customers);
    }
    public Cliente validateId() {
        while (true){
            if (customer.getId() > 0) {
                return customer;
            }
            System.out.println("Id must be greater than 0");
            System.out.print("\nIngrese un nuevo ID >> ");
            customer.setId(new Scanner(System.in).nextInt());
        }
    }

}
