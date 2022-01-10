package juegos.dao;

import juegos.modelo.Juego;

import java.sql.Array;
import java.util.Arrays;

public class DaoJuegos {

    //DATABASE
    private final Juego[] juegos;
    private int numeroJuegos;


    public DaoJuegos() {
        juegos = new Juego[10];
        numeroJuegos = 0;
        juegos[0] = new Juego("lol",5);
        numeroJuegos = 1;
    }

    public Juego[] verJuegos()
    {
        return Arrays.copyOf(juegos,numeroJuegos);
    }


//    public Juego[] verJuegosConPuntacion(int puntosMinimos)
//    {
//        Juego[] juegosTemp = new Juego[10];
//        for (int i = 0; i < numeroJuegos; i++) {
//            if (juegos[i].getPuntuacion() >= puntosMinimos )
//                juegosTemp[i] = juegos[i]
//
//        }
//
//        return Arrays.copyOf(juegos,numeroJuegos);
//    }



    public boolean lleno()
    {

        return numeroJuegos == 10;
    }

    public boolean add(Juego j)
    {
        if (lleno())
            return false;
        juegos[numeroJuegos] = j;
        numeroJuegos++;
        return true;
    }

    public Juego[] juegos()
    {
        return Arrays.copyOf(juegos,juegos.length);
    }

    public boolean borrar(String nombre)
    {
        for (int i = 0; i < numeroJuegos; i++) {
            if (juegos[i].getNombre().equals(nombre))
            {
                numeroJuegos--;
                juegos[i] = juegos[numeroJuegos];
                return true;
            }
        }
        return false;
    }



}
