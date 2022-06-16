package Files;

import Clases.Cliente;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */
public class BinaryFileSource {
    ArrayList<Cliente> customers;
    File file;

    public BinaryFileSource() {
        customers = new ArrayList<>();
        file = new File("/home/bitxanax/IdeaProjects/DataSet/files/customers.data");
    }
    public boolean add(Cliente customer) throws IOException, ClassNotFoundException {
        FileOutputStream writter = new FileOutputStream(file, true);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writter);
        objectWriter.flush();
        customers = getCustomers();
        customers.add(customer);

        objectWriter.writeObject(customers);
        objectWriter.close();
        writter.close();

        return true;
    }

    public ArrayList<Cliente> getCustomers() throws IOException, ClassNotFoundException {
        FileInputStream reader = new FileInputStream(file);
        ObjectInputStream objectReader = new ObjectInputStream(reader);

        ArrayList<Cliente> customers = (ArrayList<Cliente>) objectReader.readObject();
        customers = customers == null ? new ArrayList<>(): customers;

        objectReader.close();
        reader.close();

        return customers;
    }

    public boolean remove(String id) throws IOException, ClassNotFoundException {
        boolean success = false;
        this.getCustomers();
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writer);
        objectWriter.flush();

        for (Cliente customer : customers) {
            if (String.valueOf(customer.getId()).equals(id)) {
                customers.remove(customer);
                objectWriter.writeObject(customers);
                success = true;
            }
        }

        objectWriter.close();
        writer.close();

        return success;
    }

    public boolean update(String id, Cliente newCustomer) throws IOException, ClassNotFoundException {
        boolean success = false;
        this.getCustomers();
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writer);
        objectWriter.flush();


        for (int i = 0; i < customers.size() - 1 ; i++) {
            Cliente customer = customers.get(i);
            if (String.valueOf(customer.getId()).equals(id)) {
                customers.set(i, newCustomer);
                objectWriter.writeObject(customers);
                success = true;
                break;
            }
        }


        objectWriter.close();
        writer.close();

        return success;
    }



}
