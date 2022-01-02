package codigo;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora c = new Calculadora();
        c.suma(sc);


    }


    public void suma(Scanner sc) {
        // pedir numeros

        int numero = sc.nextInt();
        int numero2 = sc.nextInt();
        System.out.println(numero + numero2);
    }
}
