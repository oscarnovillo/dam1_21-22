package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingrediente implements Clonable<Ingrediente> {

    private String nombre;

    @Override
    public Ingrediente clonar() {
        return new Ingrediente(this.nombre);

    }
}
