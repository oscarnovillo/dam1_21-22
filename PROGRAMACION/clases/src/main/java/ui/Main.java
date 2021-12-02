package ui;

import dao.DaoPersona;
import modelo.Persona;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DaoPersona dao = new DaoPersona();

        Persona alberto = new Persona("Alberto","1111222f","Barral");
        Persona victor = new Persona("Victor","10f","Borbon");

        System.out.println(victor.getNombre());
        System.out.println(alberto.getApellido());


        victor.setApellido("burgos bengoechea");
        int numero = 6;
        cambiarPersona(numero,victor);

        cambiarPersona(numero,alberto);
        dao.addPersona(victor);

        dao.addPersona(alberto);

        dao.damePersona(0).setApellido("loco");

        System.out.println(Arrays.toString(dao.damePueblo()));



    }


    private static void cambiarPersona(int numero,Persona p)
    {

        numero = 8;

        p.setApellido("gutierrez");
    }

    /*


        Clase, Objeto instancia

        Herencia
        Polimorfismo
        Encapsulacion

     */


}
