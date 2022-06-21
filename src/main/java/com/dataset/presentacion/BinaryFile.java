package com.dataset.presentacion;

import com.dataset.clases.Cliente;
import com.dataset.logica.BinaryFileLogic;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */


public class BinaryFile {
    BinaryFileLogic logic = new BinaryFileLogic();

    public void start() {
        String option = "";

        while(!option.equals("4")) {
            System.out.println("Select an option: ");
            System.out.println("1. Text");
            System.out.println("2. Binary");
            System.out.println("3. Database");
            System.out.println("4. Exit");
            option = new Scanner(System.in).nextLine();
            findOption(option);
        }

    }

    public static void findOption(String option) {
        switch (option) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.exit(0);
        }
    }


    @Test
    public void removeTest() throws IOException, ParseException, ClassNotFoundException {

        logic.removeCustomer(String.valueOf(1));
    }

    @Test
    public void addTest() throws IOException, ParseException, ClassNotFoundException {
        Cliente customer = new Cliente(3, "Juan","12/05/2015",
                "Av. Siempre Viva", "12345678",
                "joelsebastian@gmail.com");
        logic.addCustomer(customer);
    }

    @Test
    public void getCustomersTest() throws IOException, ParseException, ClassNotFoundException {
        ArrayList<Cliente> clientes = logic.getCustomers();
        System.out.println("Clientes hallados:" + clientes.size());
        for (Cliente customer : clientes) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void updateCustomerTest() throws IOException, ParseException, ClassNotFoundException {
        Cliente customer = new Cliente(5, "Juan","12/05/2015",
                "Av. Siempre Viva", "12345678",
                "joelsebastian@gmail.com");
        logic.updateCustomer("1", customer);
    }
}
