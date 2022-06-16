package Logica;

import Clases.Cliente;
import Files.BinaryFileSource;
import Files.TextFileSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryFileLogic {
    Cliente customer;
    BinaryFileSource source;

    ArrayList<Cliente> customers = new ArrayList<>();

    public boolean addCustomer(Cliente customer) throws IOException, IOException, ClassNotFoundException {
        this.customer = customer;
        validateId();
        return source.add(customer);
    }

    public boolean removeCustomer(String id) throws IOException, ClassNotFoundException {
        return source.remove(id);
    }

    public boolean updateCustomer(String id, Cliente newCliente) throws IOException, ClassNotFoundException {
        this.customer = newCliente;
        validateId();
        return source.update("1", newCliente);
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException {
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
