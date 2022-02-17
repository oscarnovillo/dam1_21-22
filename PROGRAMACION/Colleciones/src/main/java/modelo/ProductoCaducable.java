package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductoCaducable  extends Producto {

    private LocalDateTime caducidad;

    public ProductoCaducable(double precio,
                             String nombre,
                             int stock,
                             LocalDateTime caducidad) {
        super(precio, nombre, stock);

        this.caducidad = caducidad;
    }

    @Override
    public String toString() {
        return super.toString()+"ProductoCaducable{" +
                "caducidad=" + caducidad +
                '}';
    }


}
