package ui;

import modelo.Cliente;
import modelo.LineaCompra;
import modelo.Producto;
import modelo.ProductoCaducable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class MainStreams {

    public static void main(String[] args) {


        List<Producto> productos = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            Producto p2 = new Producto(r.nextInt(100)
                    , "cono", r.nextInt(100));
            String name = ((char) (r.nextInt(26) + 'a')) + "ono";
            if (r.nextBoolean()) {

                name = ((char) (r.nextInt(26) + 'A')) + "ono";
                p2 = new ProductoCaducable(r.nextInt(100), name, r.nextInt(100), LocalDateTime.now());
            }
            p2.setNombre(name);
            productos.add(p2);
        }


        productos.stream()
                .filter(producto -> producto.getPrecio() > 50)
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()))
                .map(Producto::getNombre)
                .filter(s -> s.length() > 5)
                .forEach(System.out::println);

        Producto p = productos.stream()
                .filter(producto -> producto.getNombre().startsWith("a")
                        && producto.getStock() < 50)
                .findAny().orElse(null);
        //.orElse(new Producto(1,"kk",1));


        System.out.println(productos.stream()
                .mapToDouble(Producto::getPrecio)
                .max()
                .orElse(0));

        double max =  productos.stream()
                .mapToDouble(Producto::getPrecio)
                .max()
                .orElse(0);
        System.out.println(
                productos.stream()
                        .filter(producto -> producto.getPrecio() == max
                               )
                        .findFirst().orElse(null));


        System.out.println(productos.stream()
                .sorted((o1, o2) -> Double.compare(o2.getPrecio(),o1.getPrecio()))
                .limit(1)
                .findFirst().orElse(null));




        System.out.println(p);

        boolean b = productos.stream().anyMatch(producto -> producto.getStock() == 0);

        System.out.println(b);

        b = productos.stream().allMatch(producto -> producto.getStock() > 0);

        System.out.println(b);
        Cliente c = null;

//        productos.stream()
//                .filter(producto -> {
//                    boolean encontrado = false;
//                    for (int i = 0; i < c.getAlergenos().size(); i++) {
//                        int finalI = i;
//                        encontrado = producto.getIngredientes()
//                                .stream()
//                                .anyMatch(in -> in.equals(c.getAlergenos().get(finalI)));
//
//                    }
//                return encontrado;
//                })
//                .collect(Collectors.toList());

        c= new Cliente("1","mmm");
        c.getComprasAntiguas().add(new ArrayList<>());
        c.getComprasAntiguas().get(0).add(new LineaCompra(productos.get(0),10));
        c.getComprasAntiguas().get(0).add(new LineaCompra(productos.get(1),1));
        c.getComprasAntiguas().add(new ArrayList<>());
        c.getComprasAntiguas().get(1).add(new LineaCompra(productos.get(1),60));
        c.getComprasAntiguas().get(1).add(new LineaCompra(productos.get(2),4));

        c.getComprasAntiguas()
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println(c.getComprasAntiguas()
                .stream()
                .flatMapToDouble(lineaCompras ->
                        lineaCompras.stream()
                                .mapToDouble(value -> value.getProducto().getPrecio() * value.getCantidad()))
                .sum());


    }
}
