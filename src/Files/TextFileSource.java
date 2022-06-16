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

public class TextFileSource {

    ArrayList<Cliente> customers;
    BufferedWriter writer;
    BufferedReader reader;
    File file;

    public TextFileSource() {
        customers = new ArrayList<>();
        file = new File("/home/bitxanax/IdeaProjects/DataSet/files/customers.txt");
    }

    public boolean add(Cliente customer) throws IOException {
        writer = new BufferedWriter(new FileWriter(file, true));

        if (file.exists()) {
            writer.append(customer.toString());
            writer.close();
            return true;
        }

        return false;
    }

    //Pass empty string "", if you only want to update
    public boolean remove(String id) throws IOException {
        File temp = new File("/home/bitxanax/IdeaProjects/DataSet/files/temp.txt");
        boolean success = false;

        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        while ((line = reader.readLine()) != null) {
            if (!line.contains("customer" + id)) {
                writer.write(line+"\n");
                success = true;
            }
        }

        temp.renameTo(file);

        writer.close();
        reader.close();

        return success;
    }


    public boolean update(String id, Cliente newCustomer) throws IOException {
        File temp = new File("/home/bitxanax/IdeaProjects/DataSet/files/temp.txt");
        boolean success = false;

        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("customer" + id)) {
                writer.write(newCustomer.toString());
                success = true;
            }else{
                writer.write(line+"\n");
            }
        }

        temp.renameTo(file);

        writer.close();
        reader.close();

        return success;

    }

    public ArrayList<Cliente> getCustomers() throws IOException, ParseException {
        reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.equals("")){
                break;
            }
            customers.add(new Cliente(line));
        }

        reader.close();
        return customers;
    }


    @Test
    public void removeTest() throws IOException, ParseException {
        remove("1");
    }

    @Test
    public void addTest() throws IOException, ParseException {
        Cliente customer = new Cliente(3, "Juan","12/05/2015",
                "Av. Siempre Viva", "12345678",
                "joelsebastian@gmail.com");
        add(customer);
    }

    @Test
    public void getCustomersTest() throws IOException, ParseException {
        System.out.println("Clientes hallados:" + getCustomers().size());
    }

    @Test
    public void updateCustomerTest() throws IOException, ParseException {
        Cliente customer = new Cliente(5, "Juan","12/05/2015",
                "Av. Siempre Viva", "12345678",
                "joelsebastian@gmail.com");
        update("1", customer);
    }

}
