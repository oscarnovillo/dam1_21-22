package codigo;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    }

    public void media(int numeroNumeros,Scanner sc)
    {
        int veces = dameNumeroAleatorio();
        int suma = 0;
int numero;

        for (int i = 0; i <numeroNumeros; i++) {
            suma  += sc.nextInt();
        }
        System.out.println(suma / numeroNumeros);
    }

    public int dameNumeroAleatorio()
    {
        Random random = new Random();
        return random.nextInt(100)+1;
    }



}
