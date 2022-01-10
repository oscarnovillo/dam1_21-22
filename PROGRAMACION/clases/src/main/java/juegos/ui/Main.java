package juegos.ui;

import juegos.dao.DaoJuegos;
import juegos.modelo.Juego;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        DaoJuegos dao = new DaoJuegos();

        System.out.println(Arrays.toString(dao.verJuegos()));

//        if (!dao.lleno())
//            dao.add(new Juego("Remnant From ashes",8));
//        else
//            System.out.println("NO AÑLADIDO");
//
//
//        if (!dao.add(new Juego("Remnant From ashes",8)))
//        {
//            System.out.println("NO AÑADIDO");
//        }
//
//        //dao.add("jjj",100);
//
//        System.out.println(Arrays.toString(dao.verJuegos()));
//
//        dao.borrar("lol");
//        System.out.println(Arrays.toString(dao.verJuegos()));

}
}
