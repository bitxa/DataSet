package Clases;

import java.io.Serializable;
import java.text.ParseException;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */

public class Cliente implements Serializable {

    private int id;
    private String nombre;
    private String bornDate;
    private String address;
    private String phone;
    private String email;

    public Cliente(int id, String nombre, String bornDate, String address, String phone, String email){
        this.id = id;
        this.nombre = nombre;
        this.bornDate = bornDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


    public Cliente(String clienteString) throws ParseException {
        clienteString.replace(";", "");

        String[] cliente = clienteString.split(",");

        String idString = cliente[0].replaceAll("customer", "");
        System.out.println(idString);

        this.id = Integer.parseInt(idString);
        this.nombre = cliente[1];
        this.bornDate = cliente[2];
        this.address = cliente[3];
        this.phone = cliente[4];
        this.email = cliente[5];
        System.out.println("Cliente creado: " + this.toString());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return String.format("customer%d,%s,%s,%s,%s,%s;\n", id, nombre, String.valueOf(bornDate),
                address, phone, email);
    }
}
