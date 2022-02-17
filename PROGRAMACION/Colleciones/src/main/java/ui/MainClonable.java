package ui;

import modelo.Producto;

public class MainClonable {


    public static void main(String[] args) {


        Producto p = new Producto(10
                , "cono", 10);
        Producto p1 =(Producto)p.clonar();


        System.out.println(p1);
        p1.setNombre("clonado");

        System.out.println(p);
        System.out.println(p1);
    }
}
