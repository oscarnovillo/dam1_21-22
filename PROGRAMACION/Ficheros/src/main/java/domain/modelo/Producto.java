package domain.modelo;

import java.util.Objects;

public abstract class Producto {

    public String type;
    private String name;
    private double price;
    private int stock;



    public Producto(String name) {

        this.name = name;

    }

    public Producto(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto product = (Producto) o;
        return name.equalsIgnoreCase(product.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + name + '\'' +
                ", precio=" + price +
                ", stock=" + stock +
                '}';
    }
}
