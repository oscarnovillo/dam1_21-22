package ui.common;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.Scanner;


public class InputControl {

    private final Scanner sc ;

    @Inject
    public InputControl(Scanner sc) {
        this.sc = sc;
    }

    public int getInt(String message) {

        boolean correctInt = false;
        int numberInt = 0;
        do {
            try {
                System.out.println(message);
                numberInt = Integer.parseInt(sc.nextLine());
                correctInt = true;

            } catch (NumberFormatException format) {
                System.out.println(ConstantsGeneral.FORMATO_INCORRECTO);
            }
        } while (!correctInt);

        return numberInt;
    }

    public double getDouble(String message) {

        boolean correctInt = false;
        double numberDouble = 0;
        do {
            try {
                System.out.println(message);
                numberDouble = Double.parseDouble(sc.nextLine());
                correctInt = true;

            } catch (NumberFormatException format) {
                System.out.println(ConstantsGeneral.FORMATO_INCORRECTO);
            }
        } while (!correctInt);

        return numberDouble;
    }
}
