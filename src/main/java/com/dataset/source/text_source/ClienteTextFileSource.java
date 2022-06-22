package com.dataset.source.text_source;

import com.dataset.clases.Cliente;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;


/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */

public class ClienteTextFileSource {

    ArrayList<Cliente> customers;
    BufferedWriter writer;
    BufferedReader reader;
    File file;
    String projectPath = System.getProperty("user.dir");

    public ClienteTextFileSource() {
        customers = new ArrayList<>();
        file = new File(projectPath+"\\source\\customers.txt");
    }

    public boolean addCustomer(Cliente customer) throws IOException {
        writer = new BufferedWriter(new FileWriter(file, true));

        if (file.exists()) {
            writer.append(customer.toString());
            writer.close();
            return true;
        }

        return false;
    }

    //Pass empty string "", if you only want to update
    public boolean removeCustomer(String id) throws IOException {
        File temp = new File(projectPath+"\\source\\tempCustomers.txt");
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


    public boolean updateCustomer(String id, Cliente newCustomer) throws IOException {
        File temp = new File("/home/bitxanax/IdeaProjects/DataSet/source/temp.txt");
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

    public boolean addCustomers(ArrayList<Cliente> customers) throws IOException {
        boolean success = false;
        for (Cliente customer : customers){
            this.addCustomer(customer);
            success = true;
        }

        return success;
    }
}
