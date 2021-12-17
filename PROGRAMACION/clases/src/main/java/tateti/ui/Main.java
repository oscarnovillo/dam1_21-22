package tateti.ui;

import tateti.data.DaoTablero;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        r.nextInt(10);

        DaoTablero dao = new DaoTablero();

        System.out.println(dao.getTablero().toString());

        do {

            if (!dao.setCelda(0, 0, ValoresCelda.X)) {
                System.out.println("elige otra celda");
            }
            dao.getCelda(0, 0);
            // imprimir tablero

        } while (!dao.tresLinea() && dao.hayCeldaLibre());


    }


}
