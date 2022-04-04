package domain.modelo;


public class ProductoNormal extends Producto{


    public ProductoNormal(String name, double price, int stock) {
        super(name, price, stock);
        type ="ProductoNormal";
    }

}
