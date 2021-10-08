/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.strings;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author oscar
 */
public class MainStrings {

    public static void main(String[] args) {

        String nombre = "PEPE";
        String nombre2 = "PEPE";
        String nombre3 = new String("PEPE");

        if (nombre == nombre2) {
            System.out.println("IGUALES");
        }

        if (nombre.equalsIgnoreCase(nombre3)) {
            System.out.println("IGUALES 3 ");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Te vas a callar Sí o No?" + "jolll");
        String callarse = "SI";

        if (callarse.equalsIgnoreCase("SI")
                || callarse.equalsIgnoreCase("SÍ")) {
            System.out.println("me callo");
        }

        StringBuilder nuevoNombre = new StringBuilder();
        String acumulado = "";

        String nombreCreado = "";
        for (int i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);

            if (letra <= 'A' || letra >= 'Z') {
                letra += 32;
            }
            acumulado += letra;
            nuevoNombre.append(letra);
            nombreCreado += letra;

            System.out.println(letra);

        }

        System.out.println(acumulado + " .----. " + nuevoNombre.toString());
        String cadena = nuevoNombre.toString();
        System.out.println(cadena.toUpperCase());
        cadena = cadena.toLowerCase();
        System.out.println(cadena);


        // substring
        String linea = "hola me llmamo maria victomarriaasdd";

        System.out.println(linea.substring(5, 7));
        System.out.println(linea.substring(5));
        System.out.println(linea.substring(0, 5));
        //charat
        System.out.println(linea.charAt(5));

        //indexOf
        System.out.println(linea.substring(9));

        System.out.println(linea.substring(9).indexOf("a"));
        System.out.println(linea.indexOf("a", 4));


        System.out.println(linea.charAt(linea.length() - 1));

        int cantidadLetras = 0;
        for (int i = 0; i < linea.length(); i++) {
            if (linea.charAt(i) == 'a')
                cantidadLetras++;
        }

        cantidadLetras = 0;
        for (int i = 0; i < linea.length(); i++) {
            i = linea.indexOf("ma", i);
            if (i != -1) {
                cantidadLetras++;
//                System.out.println("no hay mas a");
//
            } else {
                i = linea.length();
            }
        }
        System.out.println("cantidad " + cantidadLetras);


        int indice = linea.indexOf("mar");

        System.out.println(linea.substring(0,indice+3)+ " "+ linea.substring(indice+3));

        System.out.println(linea.replaceFirst("mar","mar "));
        System.out.println(linea.replace("mar","mar "));




        for (int i = linea.length() - 1; i >= 0; i--) {
            i = linea.lastIndexOf("a", i);
            System.out.println(i);
        }


        //split
        String[] palabras = linea.split(" ");
        System.out.println(palabras.length);


        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

        palabras = linea.split("a");
        System.out.println(palabras.length - 1);


        String[] ahoracado = {
                "hola", "arbol", "perro",
                "daniel no se entera", "Juanjo tampoco"};

        palabras = ahoracado[3].split(" ");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

        String mi = "MI MAMA ME MIMA";
        String miBlank = "__ ____ __ ____";
        nuevoNombre = new StringBuilder("__ ____ __ ____");

         indice = mi.indexOf("A");


        miBlank = miBlank.substring(0, indice) + "A"
                + miBlank.substring(indice + 1);


        System.out.println(miBlank);
        System.out.println(nuevoNombre);
        for (int i = mi.length() - 1; i >= 0; i--) {
            i = mi.lastIndexOf("M", i);
            if (i != -1)
                nuevoNombre.replace(i, i + 1, "M");

        }

        System.out.println(nuevoNombre.toString());

        System.out.println("españa".toUpperCase());
    }


}
