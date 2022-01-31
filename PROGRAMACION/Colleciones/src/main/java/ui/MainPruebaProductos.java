package ui;

import dao.DaoProducto;
import modelo.Producto;

import java.util.List;

public class MainPruebaProductos {


    public static void main(String[] args) {

        DaoProducto dao = new DaoProducto();



        dao.verProductos().forEach(System.out::println);

        dao.addProducto(new Producto(10,"00",0));
        dao.addProducto(new Producto(10,"01",0));
        dao.addProducto(new Producto(10,"02",0));
        dao.addProducto(new Producto(10,"03",0));

        List<Producto> productos = dao.verProductos();

        productos.forEach(System.out::println);

        productos.get(0).setNombre("no se vale");


        dao.verProductos().forEach(System.out::println);
    }
}
