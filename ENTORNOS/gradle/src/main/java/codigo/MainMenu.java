package codigo;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int kaka = 1;
        String nombre = "PEPE";


        switch (kaka) {
            case 1:
                int numero;
                Calculadora c = new Calculadora();
                c.suma(sc);

                break;
            case 2:
            case 34:

                Ejercicio10 ejercicio10 = new Ejercicio10();
                ejercicio10.media(10, sc);

                break;
            case 3:
                Ejercicio10 ejercicio101 = new Ejercicio10();
                ejercicio101.media(5, sc);
                // System.out.println("cinco");
                break;
            case 5:
                ejercio();
                break;
            default:
                System.out.println("no encontrado");

        }
    }


    private static void ejercio() {
        System.out.println("seis");
    }


    public static void media2(int numeroNumeros) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;

        for (int i = 0; i < numeroNumeros; i++) {
            suma += sc.nextInt();
        }
        System.out.println(suma / numeroNumeros);
    }

}
