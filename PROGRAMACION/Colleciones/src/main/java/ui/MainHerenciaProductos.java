package ui;

import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainHerenciaProductos {


    public static void main(String[] args) {
        Producto p = new Producto(10
                , "nombre", 10);
        ProductoCaducable c = new ProductoCaducable(10
                , "nombre", 10, LocalDateTime.now());


        Producto p1 = new ProductoCaducable(10
                , "nombre", 10, LocalDateTime.now());

        ProductoCaducable c1 = ((ProductoCaducable) p1);

        List<Producto> productos = new ArrayList<>();

        productos.add(p);
        productos.add(c);
        productos.add(c1);


        productos.forEach(new Consumer<Producto>() {
            @Override
            public void accept(Producto producto) {
                System.out.println(producto);
            }
        });
        productos.forEach(producto -> System.out.println(producto));
        productos.get(1).aumentarStock(10);
        productos.forEach(System.out::println);


        productos.forEach(producto -> {
            if (producto instanceof ProductoCaducable) {
                ProductoCaducable pc = ((ProductoCaducable) producto);
                pc.setCaducidad(pc.getCaducidad().plusHours(10));
            }

        });
        productos.stream()
                .filter(producto -> {
                    boolean filtrado = true;
                    if (producto instanceof ProductoCaducable) {
                        filtrado =  ((ProductoCaducable) producto)
                                .getCaducidad().isAfter(LocalDateTime.now());
                    }
                    return filtrado;
                })
                .map(producto -> ((ProductoCaducable) producto))
                .forEach(pc -> {
                    pc.setCaducidad(pc.getCaducidad().plusHours(10));
                });

        System.out.println(productos.stream()
                .filter(ProductoCaducable.class::isInstance)
                .mapToDouble(Producto::getPrecio)
                .sum());


        productos.forEach(System.out::println);

    }

}
