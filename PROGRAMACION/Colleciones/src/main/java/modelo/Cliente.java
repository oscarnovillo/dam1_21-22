package modelo;

import java.util.Set;

public class Cliente {

    private String dni;
    private String nombre;



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' + nombre +
                '}';
    }
}
