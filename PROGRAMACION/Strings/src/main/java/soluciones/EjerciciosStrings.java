package soluciones;

import java.util.Locale;
import java.util.Scanner;

public class EjerciciosStrings {

    public static void main(String[] args) {

        //ej 1
        String cadena = "ejercicio 1";

        for (int i = 0; i < cadena.length(); i++) {
            System.out.println(cadena.charAt(i));
        }

        //ej 2
        String subfrase = "eje";
        if (cadena.startsWith(subfrase))
            System.out.println("si");
        else
            System.out.println("no");

        if (cadena.indexOf(subfrase) == 0)
            System.out.println("si");
        else
            System.out.println("no");

        //ej3
        char caracter = 'a';
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter)
                contador++;
        }

        boolean hayMas = true;
        for (int i = 0; i < cadena.length() && hayMas; i++) {
            i = cadena.indexOf(caracter, i);
            if (i != -1) contador++;
            else hayMas = false;

        }
        int indice = 0;

//        while (indice != -1) {
//            indice = cadena.indexOf(caracter,indice+1);
//            contador++;
//        }

        indice = -1;
        do {
            indice = cadena.indexOf(indice + 1, caracter);
            contador++;
        } while (indice != -1);
        contador--;


        //ej4
        cadena = cadena.trim();
        caracter = ' ';
        contador = 1;
//        for (int i = 0; i < cadena.length(); i++) {
//            i = cadena.indexOf(i, caracter);
//            if (i != -1) contador++;
//        }
        System.out.println("palabras " + contador);

        //ej5
        cadena = cadena.trim().toUpperCase();
        System.out.print(cadena.charAt(0));
        String auxiliar = "";
//        for (int i = 0; i < cadena.length(); i++) {
//            i = cadena.indexOf(i, caracter);
//            if (i != -1) auxiliar += cadena.charAt(i + 1);
//        }

        //ej6
        StringBuilder sb = new StringBuilder(cadena);

        sb.reverse();
        for (int i = cadena.length() - 1; i >= 0; i--) {
            System.out.print(cadena.charAt(i));
        }


        //ej7
        Scanner sc = new Scanner(System.in);

        cadena.replace('a', 'e');

        //ej8
        char nuevo;
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isLowerCase(cadena.charAt(i))) {
                nuevo = Character.toUpperCase(cadena.charAt(i));
            } else if (Character.isUpperCase(cadena.charAt(i)))
                nuevo = Character.toLowerCase(cadena.charAt(i));
            else
                nuevo = cadena.charAt(i);

            System.out.println(nuevo);
        }

        // ej 9
        if (cadena.contains("fragmeno"))
            System.out.println("lo tiene");

        //ej 10
        boolean palindromo = true;
        for (int i = 0, j = cadena.length() - 1; i < cadena.length() / 2 && palindromo; i++, j--) {
            if (cadena.charAt(i) != cadena.charAt(j)) {
                palindromo = false;

            }

        }
    }
}