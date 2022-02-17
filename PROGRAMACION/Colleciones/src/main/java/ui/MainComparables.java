package ui;

import modelo.Cliente;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class MainComparables {


    public static void main(String[] args) {



        Producto p = new Producto(10
                , "cono", 10);
        Producto p1 = new Producto(10
                , "cona", 10);

        List<Producto> productos = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            Producto p2 = new Producto(10
                    , "cono", 10);
            String name = ((char)(r.nextInt(26)+'a'))+"ono";
            if (r.nextBoolean()) {

                name = ((char) (r.nextInt(26) + 'A')) + "ono";
                p2 = new ProductoCaducable(10,name,10, LocalDateTime.now());
            }
            p2.setNombre(name);
            productos.add(p2);
        }
        //productos.forEach(System.out::println);

        System.out.println("OTRA LISTA");
        //productos.stream().sorted().forEach(System.out::println);

        Cliente c = new Cliente("ff");

        System.out.println(p.compareTo(p1));

    }
}
