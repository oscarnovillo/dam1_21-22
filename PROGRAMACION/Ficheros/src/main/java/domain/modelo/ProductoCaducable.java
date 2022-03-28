package domain.modelo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductoCaducable extends Producto{


    private LocalDate caducidad;



    public ProductoCaducable(String name, LocalDate caducidad) {
        super(name);
        this.caducidad = caducidad;
        type ="ProductoCaducable";
    }

    public ProductoCaducable(String name, double price, int stock, LocalDate caducidad) {
        super(name, price, stock);
        this.caducidad = caducidad;
        type ="ProductoCaducable";
    }
}
