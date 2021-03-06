package domain.modelo;


import lombok.Builder;
import lombok.Getter;

import java.util.Objects;


@Builder
@Getter
public class Cliente {
    private final String dni;
    private final String nombre;

    public Cliente(String nombre, String dni) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(dni, cliente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
