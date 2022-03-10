package ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("dame numero");
        int numero = sc.nextInt();
        System.out.println("dame numero 2");
        int numero2 = sc.nextInt();

        if ((numero > 0) && (numero2 > 0))
            System.out.println("la suma es " + (numero + numero2));
        else
            System.out.println("ERROR");




    }
}
