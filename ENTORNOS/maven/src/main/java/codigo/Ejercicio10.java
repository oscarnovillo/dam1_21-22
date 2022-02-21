package codigo;

import java.util.Random;
import java.util.Scanner;

/**
 * sñkdlfjñlskdfjñlks sdf jklhsdfjkhsdkljfh skljdfh sk akjñsdf d sdf
 *
 * @author miputamadre
 *
 */
public class Ejercicio10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    /**
     *
     *
     * @param numeroNumeros
     *            esto es el ndni del cliente que hace no se cuanto
     * @param sc
     *            este eparam es la leche
     *
     */
    public void media(int numeroNumeros, Scanner sc) {
        int veces = dameNumeroAleatorio();
        int suma = 0;
        int numero;

        for (int i = 0; i < numeroNumeros; i++) {
            suma += sc.nextInt();
        }
        System.out.println(suma / numeroNumeros);
    }

    /**
     *
     * @return devuelve la formula del oro con esencia de pitufo
     */
    public int dameNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

}
