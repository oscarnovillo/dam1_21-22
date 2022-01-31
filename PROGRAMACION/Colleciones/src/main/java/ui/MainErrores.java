package ui;

import common.MiScanner;

import java.nio.DoubleBuffer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainErrores {

    public static void main(String[] args) {

        MiScanner sc = new MiScanner();
        double d = 0;
        boolean ok = false;

        d= sc.dameNumero("dame un numero");

        double f = sc.dameDouble("dame un precio");

        System.out.println(d);
        System.out.println(f);


    }



}
