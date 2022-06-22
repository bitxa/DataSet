package com.dataset.source.text_source;

import com.dataset.clases.Factura;
import com.dataset.clases.Factura;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class FacturaTextFileSource {
    ArrayList<Factura> bills;
    BufferedWriter writer;
    BufferedReader reader;
    File file;

    String projectPath = System.getProperty("user.dir");



    public FacturaTextFileSource() {
        bills = new ArrayList<Factura>();
        file = new File(projectPath+"\\source\\bills.txt");
    }

    public boolean addCustomer(Factura bill) throws IOException {
        writer = new BufferedWriter(new FileWriter(file, true));

        if (file.exists()) {
            writer.append(bill.toString());
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
            if (!line.contains("bill" + id)) {
                writer.write(line+"\n");
                success = true;
            }
        }

        temp.renameTo(file);

        writer.close();
        reader.close();

        return success;
    }


    public boolean updateCustomer(String facturaNum, Factura newBill) throws IOException {
        File temp = new File("/home/bitxanax/IdeaProjects/DataSet/source/tempBills.txt");
        boolean success = false;

        BufferedWriter writer = new BufferedWriter(new FileWriter(temp));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains("bill" + facturaNum)) {
                writer.write(newBill.toString());
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

    public ArrayList<Factura> getCustomers() throws IOException, ParseException {
        reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            if(line.equals("")){
                break;
            }
            bills.add(new Factura(line));
        }

        reader.close();
        return bills;
    }

    public boolean addCustomers(ArrayList<Factura> bills) throws IOException {
        boolean success = false;
        for (Factura bill : bills){
            this.addCustomer(bill);
            success = true;
        }

        return success;
    }
}
