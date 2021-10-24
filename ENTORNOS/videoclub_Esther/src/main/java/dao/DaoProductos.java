package dao;

import dao.modelo.Documental;
import dao.modelo.Pelicula;
import dao.modelo.Producto;
import dao.modelo.Videojuego;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoProductos {


    private static List<Producto> productos = new ArrayList<>();

    public boolean addProducto(Producto producto) {
        boolean productoAñadido = false;
        if (!productos.contains(producto)) {
            productos.add(producto);
            productoAñadido = true;
        }
        return productoAñadido;
    }

    public boolean borrarProducto(Producto producto) {
        boolean productoBorrado = false;
        return productoBorrado = productos.remove(producto);
    }


    public List<Pelicula> getTodasPeliculas() {
        return productos.stream()
                .filter(producto -> producto instanceof Pelicula)
                .map(producto -> (Pelicula) producto)
                .collect(Collectors.toList());
    }

    public List<Videojuego> getTodosVideojuegos() {
        return productos.stream()
                .filter(producto -> producto instanceof Videojuego)
                .map(producto -> (Videojuego) producto)
                .collect(Collectors.toList());
    }

    public List<Documental> getTodosDocumentales() {
        return productos.stream()
                .filter(producto -> !(producto instanceof Pelicula)
                        && (producto instanceof Documental))
                .map(producto -> (Documental) producto)
                .collect(Collectors.toList());
    }


}
