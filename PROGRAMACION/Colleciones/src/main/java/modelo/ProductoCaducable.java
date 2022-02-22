package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductoCaducable  extends Producto {

    private LocalDateTime caducidad;

    public ProductoCaducable(double precio,
                             String nombre,
                             int stock,
                             LocalDateTime caducidad
                            ) {
        super(precio, nombre, stock);

        this.caducidad = caducidad;
    }


    public ProductoCaducable(double precio,
                             String nombre,
                             int stock,
                             LocalDateTime caducidad,
                             List<Ingrediente> ingredienteList) {
        super(precio, nombre, stock,ingredienteList);

        this.caducidad = caducidad;
    }

    @Override
    public String toString() {
        return super.toString()+"ProductoCaducable{" +
                "caducidad=" + caducidad +
                '}';
    }

    @Override
    public Producto clonar() {
        return new ProductoCaducable(this.getPrecio(), this.getNombre(), this.getStock()
                , this.getCaducidad(),this.getIngredientes()
                .stream()
                .map(Ingrediente::clonar)
                .collect(Collectors.toUnmodifiableList()));
    }
}
