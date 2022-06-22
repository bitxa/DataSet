package com.dataset.clases;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */

@Entity
@Table  (name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "born_Date", nullable = false)

    private String bornDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    public Cliente(int id, String name, String bornDate, String address, String phone, String email){
        this.id = id;
        this.name = name;
        this.bornDate = bornDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Cliente(String name, String bornDate, String address, String phone, String email){
        this.name = name;
        this.bornDate = bornDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    //Se convierte la linea de texto a un objeto Cliente
    public Cliente(String clienteString) throws ParseException {
        clienteString.replace(";", "");

        String[] cliente = clienteString.split(",");

        String idString = cliente[0].replaceAll("customer", "");
        System.out.println(idString);

        this.id = Integer.parseInt(idString);
        this.name = cliente[1];
        this.bornDate = cliente[2];
        this.address = cliente[3];
        this.phone = cliente[4];
        this.email = cliente[5];

    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente setCustomer(Cliente customer) {
        return customer;
    }



    @Override
    public String toString() {
        return String.format("customer%d,%s,%s,%s,%s,%s;\n", id, name, bornDate,
                address, phone, email);
    }
}
