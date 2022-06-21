package com.dataset.logica;

import com.dataset.clases.Cliente;
import com.dataset.files.TextFileSource;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */

public class TextFileLogic {

    Cliente customer;
    TextFileSource source;

    ArrayList<Cliente> customers = new ArrayList<>();

    public boolean addCustomer(Cliente customer) throws IOException, IOException {
        this.customer = customer;
        validateId();
        return source.addCustomer(customer);
    }

    public boolean removeCustomer(String id) throws IOException {
        this.customer = customer;
        return source.removeCustomer(id);
    }

    public boolean updateCustomer(String id, Cliente newCliente) throws IOException {
        this.customer = newCliente;
        validateId();
        return source.update("1", newCliente);
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException, ParseException {
        return source.getCustomers();
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
