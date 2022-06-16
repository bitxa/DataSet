package Presentacion;

import java.util.Scanner;

/**
 *
 * @author Joel Romero
 * date:   15/06/2022
 */
public class DataBase {
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
}
