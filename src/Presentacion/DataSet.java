package Presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */

public class DataSet {

    public static void main(String[] args) throws IOException {
        String option = "";

        while(!option.equals("4")) {
            System.out.println("Select an option: ");
            System.out.println("1. Text");
            System.out.println("2. Binary");
            System.out.println("3. Database");
            System.out.println("4. Exit");
            System.out.print("\nIngrese una opcion >> ");
            option = new Scanner(System.in).nextLine();
            findOption(option);
        }
    }

    public static void findOption(String option) throws IOException {
        switch (option) {
            case "1":
                TextFile textFile = new TextFile();
                textFile.start();
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


}
