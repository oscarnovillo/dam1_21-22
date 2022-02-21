package modelo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Data
public class Producto implements Comparable<Producto>, Clonable<Producto> {

    private double precio;
    private String nombre;
    private int stock;
    private List<Ingrediente> ingredientes;

    public Producto(double precio, String nombre, int stock, List<Ingrediente> ingredientes) {
        this.precio = precio;
        this.nombre = nombre;
        this.stock = stock;
        this.ingredientes = ingredientes;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Producto(double precio, String nombre, int stock) {
        this();
        this.precio = precio;
        this.nombre = nombre;
        this.stock = stock;
    }

    private Producto() {
        ingredientes = new ArrayList<>();
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }


    public void aumentarStock(int cantidad) {
        this.stock += cantidad;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return nombre.equalsIgnoreCase(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }


    @Override
    public int compareTo(Producto producto) {
        return this.getNombre().toLowerCase()
                .compareTo(producto.getNombre().toLowerCase());
    }

    @Override
    public Producto clonar() {
        return new Producto(this.precio, this.nombre, this.stock
                , this.ingredientes
                    .stream()
                    .map(Ingrediente::clonar)
                    .collect(Collectors.toUnmodifiableList()));
    }
}
