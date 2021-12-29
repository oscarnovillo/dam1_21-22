package tateti.ui;

import tateti.modelo.Celda;

public class MainComparar {

    public static void main(String[] args) {

        Celda c = new Celda(0,0);
        c.setValor("X");

        Celda c1 = new Celda(0,0);
        c1.setValor("X");


        if (c.equals(c1))
        {
            System.out.println("iguales");
        }

    }
}
