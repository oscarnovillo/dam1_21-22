package modelo;

import java.util.*;

public class Cliente implements  Clonable<Cliente> {

    private String dni;
    private String nombre;
    private Set<Monedero> monederos;

    private List<Ingrediente> alergenos;
    private List<LineaCompra> carrito;
    private List<List<LineaCompra>> comprasAntiguas;

    public List<Ingrediente> getAlergenos() {
        return alergenos;
    }

    public List<LineaCompra> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<LineaCompra> carrito) {
        this.carrito = carrito;
    }

    public List<List<LineaCompra>> getComprasAntiguas() {
        return comprasAntiguas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private Cliente() {
        monederos = new HashSet<>();
        carrito = new ArrayList<>();
        comprasAntiguas = new ArrayList<>();


    }

    public Cliente(String dni) {
        this();
        this.dni = dni;
    }

    public Cliente(String dni, String nombre) {
        this(dni);
        this.nombre = nombre;

    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public Set<Monedero> getMonederos() {
        return monederos;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return dni.equals(cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' + nombre +
                '}';
    }

    @Override
    public Cliente clonar() {
        return null;
    }
}
