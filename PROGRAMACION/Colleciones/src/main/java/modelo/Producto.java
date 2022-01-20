package modelo;

import java.util.Objects;

public class Producto {

    private double precio;
    private String nombre;

    public Producto(double precio, String nombre) {

        this.precio = precio;
        this.nombre = nombre;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
