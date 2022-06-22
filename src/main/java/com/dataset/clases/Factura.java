package com.dataset.clases;

import javax.persistence.*;
import java.text.ParseException;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "factura_num", nullable = false)
    private int facturaNum;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "description", nullable = false)
    private String description;

    public Factura() {
    }

    public Factura(int facturaNum, int customerId, String date, String description) {
        this.facturaNum = facturaNum;
        this.customerId = customerId;
        this.date = date;
        this.description = description;
    }


    public Factura(int customerId, String date, String description) {
        this.customerId = customerId;
        this.date = date;
        this.description = description;
    }

    public int getFacturaNum() {
        return facturaNum;
    }

    public void setFacturaNum(int facturaNum) {
        this.facturaNum = facturaNum;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Se convierte la linea de texto a un objeto Cliente
    public Factura(String facturaString) throws ParseException {
        facturaString.replace(";", "");

        String[] factura = facturaString.split(",");

        String idString = factura[0].replaceAll("customer", "");


        this.facturaNum = Integer.parseInt(idString);
        this.customerId =  Integer.parseInt(factura[1]);
        this.date = factura[2];
        this.description = factura[3];

    }

    @Override
    public String toString() {
        return String.format("bill%d,%s,%s,%s,%s,%s;\n", facturaNum,date ,
                description);
    }
}
