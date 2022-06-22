package com.dataset.source.binary_source;

import com.dataset.clases.Factura;

import java.io.*;
import java.util.ArrayList;

public class FacturaBinaryFileSource {
    ArrayList<Factura> bills;
    File file;

    String projectPath = System.getProperty("user.dir");

    public FacturaBinaryFileSource() {
        bills = new ArrayList<Factura>();
        file = new File(projectPath+"\\source\\bills.data");
    }
    public boolean addBill(Factura bill) throws IOException, ClassNotFoundException {
        FileOutputStream writter = new FileOutputStream(file, true);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writter);
        objectWriter.flush();
        bills = getBills();
        bills.add(bill);

        objectWriter.writeObject(bills);
        objectWriter.close();
        writter.close();

        return true;
    }

    public ArrayList<Factura> getBills() throws IOException, ClassNotFoundException {
        FileInputStream reader = new FileInputStream(file);
        ObjectInputStream objectReader = new ObjectInputStream(reader);

        ArrayList<Factura> bills = (ArrayList<Factura>) objectReader.readObject();
        bills = bills == null ? new ArrayList<>(): bills;

        objectReader.close();
        reader.close();

        return bills;
    }

    public boolean removeBill(String facturaNum) throws IOException, ClassNotFoundException {
        boolean success = false;
        this.getBills();
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writer);
        objectWriter.flush();

        for (Factura bill : bills) {
            if (String.valueOf(bill.getFacturaNum()).equals(facturaNum)) {
                bills.remove(bill);
                objectWriter.writeObject(bills);
                success = true;
            }
        }

        objectWriter.close();
        writer.close();

        return success;
    }

    public boolean updateBill(String facturaNum, Factura newCustomer) throws IOException, ClassNotFoundException {
        boolean success = false;
        this.getBills();
        FileOutputStream writer = new FileOutputStream(file);
        ObjectOutputStream objectWriter = new ObjectOutputStream(writer);
        objectWriter.flush();


        for (int i = 0; i < bills.size() - 1 ; i++) {
            Factura bill = bills.get(i);
            if (String.valueOf(bill.getFacturaNum()).equals(facturaNum)) {
                bills.set(i, newCustomer);
                objectWriter.writeObject(bills);
                success = true;
                break;
            }
        }


        objectWriter.close();
        writer.close();

        return success;
    }

    public boolean addBills(ArrayList<Factura> bills) throws IOException, ClassNotFoundException {
        boolean success = false;
        for (Factura bill : bills){
            this.addBill(bill);
            success = true;
        }

        return success;
    }

}